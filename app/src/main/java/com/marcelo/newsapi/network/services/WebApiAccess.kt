package com.marcelo.newsapi.network.services

import com.haroldadmin.cnradapter.NetworkResponseAdapterFactory
import com.marcelo.newsapi.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object WebApiAccess {

    private fun startRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.URL_BASE)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(NetworkResponseAdapterFactory())
            .build()
    }

    fun serviceNews(): NewsApiClient = startRetrofit().create(NewsApiClient::class.java)

    /*val newsApi : NewsApiClient by lazy {

        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.URL_BASE)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(NetworkResponseAdapterFactory())
            .build()

        return@lazy retrofit.create(NewsApiClient::class.java)
    }*/
}