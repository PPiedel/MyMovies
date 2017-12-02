package com.example.pawel_piedel.mymovies.injection.module

import com.example.pawel_piedel.mymovies.data.source.RemoteRepository
import com.example.pawel_piedel.mymovies.movies.MoviesViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Pawel_Piedel on 01.11.2017.
 */
@Module
class ViewModelModule {

    @Provides
    @Singleton
    fun provideMoviesViewModel(moviesRepository: RemoteRepository): MoviesViewModel = MoviesViewModel(moviesRepository)
}