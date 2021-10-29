package com.marcelo.newsapi.models

import com.marcelo.newsapi.data.models.Article

sealed class NewsResult {
    class Success(val articles: List<Article>) : NewsResult()
    class ApiError(val code: Int, val message: String?) : NewsResult()
    class UnknownError(val message: String?) : NewsResult()
}