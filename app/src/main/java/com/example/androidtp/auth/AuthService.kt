package com.example.androidtp.auth

import com.example.androidtp.api.ResponseAPI
import com.example.androidtp.api.RetrofitTools.Companion.retrofit
import com.example.androidtp.article.ArticleService
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    companion object {
        // Token stocké dans l'app (si on redémarre l'app c'est reset)
        var token : String = "";
    }

    @POST("login")
    suspend fun login(@Body loginRequestData: LoginRequestData) : ResponseAPI<String>

    object AuthApi {
        val authService : AuthService by lazy { retrofit.create(AuthService::class.java) }
    }
}