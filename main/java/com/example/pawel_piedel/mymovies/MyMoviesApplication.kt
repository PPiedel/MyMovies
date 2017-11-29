package com.example.pawel_piedel.mymovies

import android.app.Application
import android.content.Context
import com.example.pawel_piedel.myapplication.BuildConfig
import com.example.pawel_piedel.mymovies.injection.component.AppComponent
import com.example.pawel_piedel.mymovies.injection.component.DaggerAppComponent
import com.example.pawel_piedel.mymovies.injection.module.AppModule
import timber.log.Timber

/**
 * Created by Pawel_Piedel on 31.10.2017.
 */
class MyMoviesApplication : Application() {
    private var appComponent: AppComponent? = null

    var component: AppComponent
        get() {
            if (appComponent == null) {
                initDagger()
            }
            return appComponent as AppComponent
        }
        set(appComponent) {
            this.appComponent = appComponent
        }

    private fun initDagger() {
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    companion object {
        operator fun get(context: Context): MyMoviesApplication =
                context.applicationContext as MyMoviesApplication
    }
}