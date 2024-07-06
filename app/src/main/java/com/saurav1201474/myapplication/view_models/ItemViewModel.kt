package com.saurav1201474.myapplication.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.saurav1201474.myapplication.models.Item
import com.saurav1201474.myapplication.repository.ItemRepository

//our viewmodel will act as an bridge between ui and the repo
class ItemViewModel:ViewModel() {
    //use the repo here
    private val repository = ItemRepository()


    val items: LiveData<List<Item>> by lazy {
        repository.getItems()
    }
}