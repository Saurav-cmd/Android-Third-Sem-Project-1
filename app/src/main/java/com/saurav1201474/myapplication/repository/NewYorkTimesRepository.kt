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

    fun fetchArticles(): LiveData<List<ArticlesModel>> {
        val data = MutableLiveData<List<ArticlesModel>>()

        apiService.getArticles().enqueue(object : Callback<List<ArticlesModel>> {
            override fun onResponse(
                call: Call<List<ArticlesModel>>,
                response: Response<List<ArticlesModel>>
            ) {
                if (response.isSuccessful) {
                    data.value = response.body()
                    Log.d("API call success", "${data.value}")
                } else {
                    // handle the error here
                    data.value = emptyList() // or null based on how you want to handle it
                    Log.d("API call empty", "${data.value}")

                }
            }

            override fun onFailure(call: Call<List<ArticlesModel>>, t: Throwable) {
                // handle the failure here
                data.value = emptyList() // or null based on how you want to handle it
                Log.d("API call fail", "${data.value}")

            }
        })

        return data
    }
}
