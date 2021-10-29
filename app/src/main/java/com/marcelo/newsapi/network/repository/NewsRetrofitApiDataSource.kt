package com.marcelo.newsapi.network.repository

import com.haroldadmin.cnradapter.NetworkResponse
import com.marcelo.newsapi.models.NewsResult
import com.marcelo.newsapi.network.services.NewsApiClient

class NewsRetrofitApiDataSource (private val newsApiClient: NewsApiClient) : NewsApiDataSource {

    override suspend fun fetchNews(): NewsResult {
        return when (val newsResponse = newsApiClient.getNews()) {
            is NetworkResponse.Success -> {
                val articles = newsResponse.body.articles
                NewsResult.Success(articles)
            }
            is NetworkResponse.ServerError -> {
                NewsResult.ApiError(newsResponse.code, newsResponse.body?.message)
            }
            else -> NewsResult.UnknownError("Unknown error")
        }
    }
}