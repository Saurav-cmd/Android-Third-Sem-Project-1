package com.saurav1201474.myapplication.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bhuwan.TimesWireModal
import com.saurav1201474.myapplication.repository.NewYorkTimesRepository
import kotlinx.coroutines.launch

class TimesWireViewModel : ViewModel() {
    private val repository = NewYorkTimesRepository()

    private val _timesWire = MutableLiveData<TimesWireModal>()
    val timesWire: LiveData<TimesWireModal>
        get() = _timesWire

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private fun fetchTimesWire() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val fetchedTimeWire = repository.fetchTimesWire()
                _timesWire.value = fetchedTimeWire
            } catch (e: Exception) {
                _timesWire.value = TimesWireModal()
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun refreshArticle() {
        fetchTimesWire()
    }
}