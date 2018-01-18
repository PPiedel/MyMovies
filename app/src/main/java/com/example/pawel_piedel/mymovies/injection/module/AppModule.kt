package com.example.pawel_piedel.mymovies.injection.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module()
class AppModule(private val application: Application) {

    @Provides
    internal fun provideApplication(): Application {
        return application
    }

    @Provides
    @Singleton
    internal fun provideContext(): Context {
        return application
    }
}