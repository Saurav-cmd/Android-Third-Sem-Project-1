package com.saurav1201474.myapplication.api_service

import com.saurav1201474.myapplication.constants.UrlConst
import com.saurav1201474.myapplication.models.ArticlesModel
import retrofit2.Call
import retrofit2.http.GET

//this is where you will define the api services
interface ApiService {
    @GET(UrlConst.ARTICLES_URL)
    fun getArticles(): Call<List<ArticlesModel>>
}