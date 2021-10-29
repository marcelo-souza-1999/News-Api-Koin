package com.marcelo.newsapi.app

import android.app.Application
import com.marcelo.newsapi.directory.networkModule
import com.marcelo.newsapi.directory.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class NewsApiApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@NewsApiApp)
            modules(listOf(
                networkModule,
                repositoryModule
            ))
        }
    }
}