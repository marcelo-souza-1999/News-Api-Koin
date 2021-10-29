package com.marcelo.newsapi.network.repository

import com.marcelo.newsapi.models.NewsResult

interface NewsApiDataSource {

    suspend fun fetchNews(): NewsResult
}