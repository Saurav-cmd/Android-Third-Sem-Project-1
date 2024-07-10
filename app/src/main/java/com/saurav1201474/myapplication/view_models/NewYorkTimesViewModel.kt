package com.saurav1201474.myapplication.view_models

import ArticlesModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saurav1201474.myapplication.repository.NewYorkTimesRepository
import kotlinx.coroutines.launch


class NewYorkTimesViewModel : ViewModel() {

    private val repository = NewYorkTimesRepository()

    private val _articles = MutableLiveData<ArticlesModel>()
    val articles: LiveData<ArticlesModel>
        get() = _articles

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading


    init {
        fetchArticles()
    }

    private fun fetchArticles() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val fetchedArticles = repository.fetchArticles()
                _articles.value = fetchedArticles
            } catch (e: Exception) {
                _articles.value = ArticlesModel()
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun refreshArticle(){
        fetchArticles()
    }
}
