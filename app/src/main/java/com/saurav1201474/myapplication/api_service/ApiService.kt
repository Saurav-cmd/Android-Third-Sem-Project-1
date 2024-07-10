package com.saurav1201474.myapplication.api_service


import ArticlesModel
import com.saurav1201474.myapplication.constants.UrlConst
import retrofit2.http.GET

interface ApiService {
    @GET(UrlConst.ARTICLES_URL)
    suspend fun getArticles(): ArticlesModel

}