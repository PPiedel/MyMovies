package com.example.pawel_piedel.mymovies.injection.module

import com.example.pawel_piedel.mymovies.data.source.MoviesDataSource
import com.example.pawel_piedel.mymovies.data.source.MoviesRepository
import com.example.pawel_piedel.mymovies.data.source.local.LocalDataSource
import com.example.pawel_piedel.mymovies.data.source.remote.RemoteDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Pawel_Piedel on 31.10.2017.
 */
@Module
class DataModule {
    @Singleton
    @Provides
    fun provideMoviesRepository(remoteDataSource: RemoteDataSource, localDataSource: LocalDataSource): MoviesRepository = MoviesRepository(remoteDataSource, localDataSource)
}