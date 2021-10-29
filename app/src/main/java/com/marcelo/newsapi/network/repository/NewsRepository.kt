package com.marcelo.newsapi.network.repository

import android.content.Context
import com.marcelo.newsapi.models.NewsResult

class NewsRepository(private val context: Context, private val newsApiDataSource: NewsApiDataSource) : NewsRepositoryInterface {

    override suspend fun getNews(): NewsResult {
        return newsApiDataSource.fetchNews()
    }
}