package com.example.businesscontrollv3.infra.webservice

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object LoginAPI {

    private const val API_BASE_URL =  "https://business-controll-backend.herokuapp.com"

    private val okHttpCliente : OkHttpClient by lazy {
        val client = OkHttpClient.Builder()
        client.addInterceptor((provideLooginInterceptor()))
        client.build()
    }

    private val retrofit:Retrofit by lazy{
        Retrofit
            .Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val loginService: LoginService by lazy{
        retrofit.create(LoginService::class.java)
    }
    private fun provideLooginInterceptor(): HttpLoggingInterceptor{
        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BODY
        return logger
    }
}