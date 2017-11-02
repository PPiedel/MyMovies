package com.example.pawel_piedel.mymovies.injection.module

import com.example.pawel_piedel.mymovies.data.source.MoviesDataSource
import com.example.pawel_piedel.mymovies.ui.main.MainContract
import com.example.pawel_piedel.mymovies.ui.main.MainPresenter
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
    fun provideMoviesPresenter(moviesDataSource: MoviesDataSource): MainContract.Presenter = MainPresenter(moviesDataSource)

}