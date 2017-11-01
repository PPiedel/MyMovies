package com.example.pawel_piedel.mymovies.injection.module

import com.example.pawel_piedel.mymovies.data.source.MoviesDataSource
import com.example.pawel_piedel.mymovies.ui.movies.MoviesContract
import com.example.pawel_piedel.mymovies.ui.movies.MoviesPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Pawel_Piedel on 01.11.2017.
 */
@Module
class PresenterModule {

    @Provides
    @Singleton
    fun provideMoviesPresenter(moviesDataSource: MoviesDataSource): MoviesContract.Presenter = MoviesPresenter(moviesDataSource)

}