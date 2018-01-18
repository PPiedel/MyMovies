package com.example.pawel_piedel.mymovies.injection.component

import com.example.pawel_piedel.mymovies.injection.module.ApiModule
import com.example.pawel_piedel.mymovies.injection.module.AppModule
import com.example.pawel_piedel.mymovies.injection.module.DataModule
import com.example.pawel_piedel.mymovies.injection.module.ViewModelModule
import com.example.pawel_piedel.mymovies.movie_details.MovieDetailsActivity
import com.example.pawel_piedel.mymovies.movies.MoviesFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, ViewModelModule::class, ApiModule::class, DataModule::class))
interface AppComponent {
    fun inject(moviesFragment: MoviesFragment)

    fun inject(movieDetailsActivity: MovieDetailsActivity)
}
