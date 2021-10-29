package com.marcelo.newsapi.network.repository

import com.marcelo.newsapi.models.NewsResult

interface NewsRepositoryInterface {

    suspend fun getNews(): NewsResult
}