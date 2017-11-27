package com.example.pawel_piedel.mymovies.injection.module

import android.content.Context
import com.example.pawel_piedel.mymovies.data.model.model.Models
import com.example.pawel_piedel.mymovies.data.source.RemoteRepository
import com.example.pawel_piedel.mymovies.data.source.local.LocalDataSource
import com.example.pawel_piedel.mymovies.data.source.local.LocalSource
import com.example.pawel_piedel.mymovies.data.source.remote.RemoteSource
import dagger.Module
import dagger.Provides
import io.requery.Persistable
import io.requery.android.sqlite.DatabaseSource
import io.requery.reactivex.KotlinReactiveEntityStore
import io.requery.sql.KotlinEntityDataStore
import io.requery.sql.TableCreationMode
import javax.inject.Singleton

/**
 * Created by Pawel_Piedel on 31.10.2017.
 */
@Module
class DataModule {

    @Singleton
    @Provides
    fun provideKotlinReactiveEntityStore(context: Context): KotlinReactiveEntityStore<Persistable> {
        val source: DatabaseSource = DatabaseSource(context, Models.DEFAULT, 1)
        source.setTableCreationMode(TableCreationMode.DROP_CREATE)
        return KotlinReactiveEntityStore<Persistable>(KotlinEntityDataStore(source.configuration))
    }

    @Singleton
    @Provides
    fun provideLocalDataSource(data: KotlinReactiveEntityStore<Persistable>) = LocalSource(data)

    @Singleton
    @Provides
    fun provideMoviesRepository(remoteSource: RemoteSource, localSource: LocalDataSource): RemoteRepository = RemoteRepository(remoteSource, localSource)
}