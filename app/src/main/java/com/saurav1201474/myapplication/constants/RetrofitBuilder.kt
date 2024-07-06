package com.saurav1201474.myapplication.constants

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//this is the retrofit builder object class
object RetrofitBuilder {

    private const val BASE_URL = "https://api.nytimes.com/svc"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun <T> createService(service: Class<T>): T {
        return retrofit.create(service)
    }
}