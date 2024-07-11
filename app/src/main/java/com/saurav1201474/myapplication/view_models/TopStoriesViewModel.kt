package com.saurav1201474.myapplication.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saurav1201474.myapplication.models.TopstoriesModal
import com.saurav1201474.myapplication.repository.NewYorkTimesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TopStoriesViewModel() : ViewModel() {

    private val repository = NewYorkTimesRepository()

    private val _topStories = MutableLiveData<TopstoriesModal>()
    val topStories: LiveData<TopstoriesModal>
        get() = _topStories

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    init {
        fetchTopStories()
    }

    private fun fetchTopStories() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val fetchedTopStories = repository.fetchTopArticles()
                _topStories.value = fetchedTopStories
            } catch (e: Exception) {
                _topStories.value = TopstoriesModal()
            } finally {
                _isLoading.value = false
            }

        }
    }

}