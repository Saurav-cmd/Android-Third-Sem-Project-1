package com.saurav1201474.myapplication.constants

import com.saurav1201474.myapplication.api_service.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.Gson
import com.google.gson.GsonBuilder

object RetrofitBuilder {

    private val gson: Gson = GsonBuilder()
        .setLenient()
        .create()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(UrlConst.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    fun createService(): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}
