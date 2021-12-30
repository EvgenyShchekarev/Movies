package com.schekarev.movies.application

import android.app.Application
import com.schekarev.movies.di.application
import com.schekarev.movies.di.mainScreen
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MoviesApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(application, mainScreen)
        }
    }
}