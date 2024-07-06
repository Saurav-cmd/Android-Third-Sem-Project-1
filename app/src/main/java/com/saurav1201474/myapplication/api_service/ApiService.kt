package com.saurav1201474.myapplication.api_service

import com.saurav1201474.myapplication.models.Item
import retrofit2.Call
import retrofit2.http.GET

//this is where you will define the api services
interface ApiService {
    @GET("search/v2/articlesearch.json?q=election&api-key=NFOb2nTHipmzq9mKHrG8m0ZS5t9N82ZU")
    fun getItems():Call<List<Item>>
}