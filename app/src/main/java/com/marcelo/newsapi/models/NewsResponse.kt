package com.marcelo.newsapi.models

import com.marcelo.newsapi.data.models.Article
import com.squareup.moshi.Json

data class NewsResponse(
    @field:Json(name = "articles") val articles: List<Article>,
    @field:Json(name = "status") val status: String,
    @field:Json(name = "totalResults") val totalResults: Int
)