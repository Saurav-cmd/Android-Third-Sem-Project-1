package com.saurav1201474.myapplication.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.saurav1201474.myapplication.api_service.ApiService
import com.saurav1201474.myapplication.constants.RetrofitBuilder
import com.saurav1201474.myapplication.models.Item
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//do the api call login here
class ItemRepository {
    private val apiService: ApiService = RetrofitBuilder.createService(ApiService::class.java)

    fun getItems(): LiveData<List<Item>> {
        val data = MutableLiveData<List<Item>>()

        apiService.getItems().enqueue(object : Callback<List<Item>> {
            override fun onResponse(call: Call<List<Item>>, response: Response<List<Item>>) {
                if (response.isSuccessful) {
                    data.value = response.body()
                } else {
                    // handle the error here
                    data.value = emptyList() // or null based on how you want to handle it
                }
            }

            override fun onFailure(call: Call<List<Item>>, t: Throwable) {
                // handle the failure here
                data.value = emptyList() // or null based on how you want to handle it
            }
        })

        return data
    }
}
