package com.saurav1201474.myapplication.repository

import ArticlesModel
import android.util.Log
import com.saurav1201474.myapplication.api_service.ApiService
import com.saurav1201474.myapplication.constants.RetrofitBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.await


class NewYorkTimesRepository {
    private val apiService: ApiService = RetrofitBuilder.createService()

    suspend fun fetchArticles(): ArticlesModel {
        return withContext(Dispatchers.IO) {
            try {
                Log.d("Fetch Articles....", "Inside fetch article")
                val response = apiService.getArticles()
                response // Return the ArticlesModel directly
            } catch (e: Exception) {
                Log.e("MainActivity", "Error fetching articles: ${e.message}", e)
                ArticlesModel() // Return a default ArticlesModel or handle error case
            }
        }
    }
}

