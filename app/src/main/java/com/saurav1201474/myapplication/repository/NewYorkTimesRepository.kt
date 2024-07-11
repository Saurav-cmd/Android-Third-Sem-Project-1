package com.saurav1201474.myapplication.repository

import ArticlesModel
import bhuwan.TimesWireModal
import com.saurav1201474.myapplication.constants.RetrofitBuilder
import com.saurav1201474.myapplication.models.TopstoriesModal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NewYorkTimesRepository {
//    private val apiService: ApiService = RetrofitBuilder.createService()

    //Instance of RetrofitBuilder
    private val apiService = RetrofitBuilder.createService

    suspend fun fetchArticles(): ArticlesModel {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiService.getArticles()
                response
            } catch (e: Exception) {
                ArticlesModel()
            }
        }
    }

    suspend fun fetchTopArticles(): TopstoriesModal {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiService.getTopStories()
                response
            } catch (e: Exception) {
                TopstoriesModal()
            }
        }
    }

    suspend fun fetchTimesWire(): TimesWireModal {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiService.getTimesWire()
                response
            } catch (e: Exception) {
                TimesWireModal()
            }
        }
    }
}