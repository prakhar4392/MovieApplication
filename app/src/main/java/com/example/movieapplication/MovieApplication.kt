package com.example.movieapplication

import android.app.Application
import com.example.movieapplication.di.appModule
import org.koin.core.context.startKoin

class MovieApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(appModule)
        }
    }
}