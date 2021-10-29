package com.marcelo.newsapi.network.repository

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.marcelo.newsapi.BuildConfig
import com.marcelo.newsapi.models.NewsResponse
import com.marcelo.newsapi.models.NewsResult
import kotlin.coroutines.suspendCoroutine

class NewsFANApiDataSource : NewsApiDataSource {

    override suspend fun fetchNews(): NewsResult {
        return suspendCoroutine { continuation ->
            AndroidNetworking.get(BuildConfig.URL_BASE + "top-headlines?country=br")
                .addQueryParameter("category", "technology")
                .addQueryParameter("apiKey", BuildConfig.KEY_NEWS_API)
                .build()
                .getAsObject(
                    NewsResponse::class.java,
                    object : ParsedRequestListener<NewsResponse> {
                        override fun onResponse(response: NewsResponse?) {
                            response?.let {
                                continuation.resumeWith(Result.success(NewsResult.Success(it.articles)))
                            }
                        }

                        override fun onError(anError: ANError?) {
                            continuation.resumeWith(Result.failure(Throwable("Unknown error")))
                        }
                    })
        }
    }
}