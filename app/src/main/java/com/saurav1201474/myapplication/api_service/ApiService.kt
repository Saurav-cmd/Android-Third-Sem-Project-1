package com.saurav1201474.myapplication.api_service


import ArticlesModel
import bhuwan.TimesWireModal
import com.saurav1201474.myapplication.constants.UrlConst
import com.saurav1201474.myapplication.models.TopstoriesModal
import retrofit2.http.GET

interface ApiService {
    @GET(UrlConst.ARTICLES_URL)
    suspend fun getArticles(): ArticlesModel

    @GET(UrlConst.TOP_STORIES_URL)
    suspend fun getTopStories() : TopstoriesModal

    @GET(UrlConst.TIMES_WIRE)
    suspend fun getTimesWire() : TimesWireModal

}