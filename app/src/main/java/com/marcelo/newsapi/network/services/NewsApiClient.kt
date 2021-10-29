package com.marcelo.newsapi.network.services

import com.marcelo.newsapi.BuildConfig
import com.marcelo.newsapi.data.models.ErrorResponse
import com.marcelo.newsapi.models.NewsResponse
import com.haroldadmin.cnradapter.NetworkResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiClient {

    @GET("top-headlines?country=br")
    suspend fun getNews(
        @Query("category") category: String = "technology",
        @Query("apiKey") apiKey: String = BuildConfig.KEY_NEWS_API
    ): NetworkResponse<NewsResponse, ErrorResponse>
}