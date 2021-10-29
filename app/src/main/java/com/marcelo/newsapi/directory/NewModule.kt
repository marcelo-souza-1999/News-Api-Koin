package com.marcelo.newsapi.directory

import com.marcelo.newsapi.network.repository.NewsApiDataSource
import com.marcelo.newsapi.network.repository.NewsRepository
import com.marcelo.newsapi.network.repository.NewsRetrofitApiDataSource
import com.marcelo.newsapi.network.services.WebApiAccess.serviceNews
import com.marcelo.newsapi.ui.viewmodel.NewsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module

val networkModule = module {
    single {
        serviceNews()
    }
}

val repositoryModule = module {

    single {
        NewsRepository(get(), get())
    }

    single <NewsApiDataSource> { NewsRetrofitApiDataSource(get()) }
}

val viewModelModule = module {

    viewModel {
        NewsViewModel(get())
    }
}