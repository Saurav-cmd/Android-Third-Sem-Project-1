package com.saurav1201474.myapplication.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.saurav1201474.myapplication.api_service.ApiService
import com.saurav1201474.myapplication.constants.RetrofitBuilder
import com.saurav1201474.myapplication.models.ArticlesModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//do the api call login here
class NewYorkTimesRepository {
    private val apiService: ApiService = RetrofitBuilder.createService(ApiService::class.java)

    fun fetchArticles(): LiveData<ArticlesModel> {
        val data = MutableLiveData<ArticlesModel>()
        Log.d("Fetch Articles....", "Inside fetch article")
        apiService.getArticles().enqueue(object : Callback<ArticlesModel> {
            override fun onResponse(
                call: Call<ArticlesModel>,
                response: Response<ArticlesModel>
            ) {
                Log.d("MainActivity", "com.saurav1201474.myapplication.models.Response Code: ${response.code()}") // Log HTTP response code
                if (response.isSuccessful && response.body() != null) {
                    data.value = response.body()
                } else {
                    data.value = null
                    //null
                }
            }

            override fun onFailure(call: Call<ArticlesModel>, t: Throwable) {
                data.value = null //nsure data is never null
                Log.e("MainActivity", "Error fetching articles: ${t.message}", t)
            }
        })

        return data
    }
}
