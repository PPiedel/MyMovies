package com.example.pawel_piedel.mymovies.injection.component

import android.app.Application
import android.content.Context
import com.example.pawel_piedel.mymovies.injection.module.AppModule
import dagger.Component
import com.example.pawel_piedel.mymovies.injection.ApplicationContext
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    @ApplicationContext
    fun context(): Context

    fun application(): Application
}
