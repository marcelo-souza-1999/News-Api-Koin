package com.marcelo.newsapi.directory

import com.marcelo.newsapi.network.repository.NewsRepository
import com.marcelo.newsapi.network.repository.NewsRepositoryInterface
import com.marcelo.newsapi.network.services.WebApiAccess.serviceNews
import com.marcelo.newsapi.ui.viewmodel.NewsViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module

val networkModule = module {
    factory {
        serviceNews()
    }
}

val repositoryModule = module {

    single {
        NewsRepository(get(), get())
    } bind NewsRepositoryInterface::class

    viewModel {
        NewsViewModel(get())
    }
}
