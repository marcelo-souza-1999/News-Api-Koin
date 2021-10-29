package com.marcelo.newsapi.data.models

import com.squareup.moshi.Json

data class ErrorResponse(
    @field:Json(name = "message") val message: String
)