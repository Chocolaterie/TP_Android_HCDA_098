package com.example.androidtp.article

import com.example.androidtp.api.ResponseAPI
import com.example.androidtp.api.RetrofitTools.Companion.retrofit
import retrofit2.http.GET

interface ArticleService {

    @GET("articles")
    suspend fun getArticles() : ResponseAPI<List<Article>>

    object ArticleApi {
        val articleService : ArticleService by lazy { retrofit.create(ArticleService::class.java) }
    }

}