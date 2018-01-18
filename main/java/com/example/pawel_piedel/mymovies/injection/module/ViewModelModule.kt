package com.example.pawel_piedel.mymovies.injection.module

import com.example.pawel_piedel.mymovies.data.source.MoviesRepository
import com.example.pawel_piedel.mymovies.movie_details.MovieDetailsViewModel
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
    fun provideMoviesViewModel(moviesRepository: MoviesRepository): MoviesViewModel = MoviesViewModel(moviesRepository)

    @Provides
    @Singleton
    fun provideMovieDetailsViewModel(moviesRepository: MoviesRepository): MovieDetailsViewModel = MovieDetailsViewModel(moviesRepository)
}