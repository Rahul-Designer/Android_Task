package com.example.randomquote_retrofit_example.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidtask.Model.ResultItem
import com.example.androidtask.Model.ResultList
import com.example.androidtask.Repository.JsonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val jsonRepository: JsonRepository) : ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO) {
            jsonRepository.getJsonData()

        }
    }

    val json: LiveData<List<ResultItem>>
        get() = jsonRepository.jsonData

}