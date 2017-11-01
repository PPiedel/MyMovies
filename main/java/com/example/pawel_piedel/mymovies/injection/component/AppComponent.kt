package com.example.pawel_piedel.mymovies.injection.component

import com.example.pawel_piedel.mymovies.injection.module.ApiModule
import com.example.pawel_piedel.mymovies.injection.module.AppModule
import com.example.pawel_piedel.mymovies.injection.module.DataModule
import com.example.pawel_piedel.mymovies.injection.module.PresenterModule
import com.example.pawel_piedel.mymovies.ui.movies.MoviesActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, PresenterModule::class, ApiModule::class, DataModule::class))
interface AppComponent {
    fun inject(moviesActivity: MoviesActivity)
}
