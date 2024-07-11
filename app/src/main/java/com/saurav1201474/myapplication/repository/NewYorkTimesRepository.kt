package com.saurav1201474.myapplication.repository

import ArticlesModel
import android.util.Log
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
                Log.d("Fetch Articles....", "Inside fetch article")
                val response = apiService.getArticles()
                response
            } catch (e: Exception) {
                Log.e("MainActivity", "Error fetching articles: ${e.message}", e)
                ArticlesModel()
            }
        }
    }

    suspend fun fetchTopArticles() : TopstoriesModal{
        return withContext(Dispatchers.IO){
            try {
                val response = apiService.getTopStories()
                response
            } catch (e: Exception) {
                TopstoriesModal()
            }
        }
    }

}