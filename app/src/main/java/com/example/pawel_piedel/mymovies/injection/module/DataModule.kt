package com.example.pawel_piedel.mymovies.injection.module

import android.content.Context
import com.example.pawel_piedel.mymovies.data.source.MoviesRepository
import com.example.pawel_piedel.mymovies.data.source.local.LocalDataSource
import com.example.pawel_piedel.mymovies.data.source.local.LocalSource
import com.example.pawel_piedel.mymovies.data.source.remote.ApiService
import com.example.pawel_piedel.mymovies.data.source.remote.RemoteDataSource
import com.example.pawel_piedel.mymovies.data.source.remote.RemoteSource
import dagger.Module
import dagger.Provides
import io.realm.Realm
import io.realm.RealmConfiguration
import timber.log.Timber
import javax.inject.Singleton

/**
 * Created by Pawel_Piedel on 31.10.2017.
 */
@Module
class DataModule {
    @Singleton
    @Provides
    fun provideMoviesRepository(remoteSource: RemoteDataSource, localDataSource: LocalDataSource): MoviesRepository {
        return MoviesRepository(remoteSource, localDataSource)
    }

    @Provides
    @Singleton
    fun provideRemoteDataSource(apiService: ApiService) : RemoteDataSource {
        return RemoteSource(apiService)
    }

    @Provides
    @Singleton
    fun provideLocalDataSource(realm: Realm): LocalDataSource {
        return LocalSource(realm)
    }

    @Provides
    @Singleton
    internal fun provideRealm(config: RealmConfiguration): Realm {
        Realm.setDefaultConfiguration(config)
        return try {
            Realm.getDefaultInstance()
        } catch (e: Exception) {
            Timber.e(e)
            Realm.deleteRealm(config)
            Realm.setDefaultConfiguration(config)
            Realm.getDefaultInstance()
        }

    }

    @Singleton
    @Provides
    internal fun provideRealmConfig(context: Context): RealmConfiguration {
        Realm.init(context)
        return RealmConfiguration.Builder()
                .schemaVersion(DATABASE_VERSION.toLong())
                .deleteRealmIfMigrationNeeded()
                .build()
    }

    companion object {
        const val DATABASE_VERSION = 1
    }
}