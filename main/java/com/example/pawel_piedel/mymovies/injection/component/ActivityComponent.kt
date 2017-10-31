package com.example.pawel_piedel.mymovies.injection.component

import com.example.pawel_piedel.mymovies.base.BaseActivity
import com.example.pawel_piedel.mymovies.injection.PerActivity
import com.example.pawel_piedel.mymovies.injection.module.ActivityModule
import com.example.pawel_piedel.mymovies.movies.MoviesActivity
import dagger.Subcomponent

@PerActivity
@Subcomponent(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun inject(baseActivity: BaseActivity)

    fun inject(moviesActivity: MoviesActivity)
}
