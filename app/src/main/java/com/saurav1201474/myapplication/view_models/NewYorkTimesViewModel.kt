package com.saurav1201474.myapplication.view_models


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.saurav1201474.myapplication.models.ArticlesModel
import com.saurav1201474.myapplication.repository.NewYorkTimesRepository

//our viewmodel will act as an bridge between ui and the repo
class NewYorkTimesViewModel : ViewModel() {
    //use the repo here
    private val repository = NewYorkTimesRepository()

    init {

    }

    val articles: LiveData<ArticlesModel> by lazy {
        Log.d("data","pasya xa ki nai")
        repository.fetchArticles()

    }
}