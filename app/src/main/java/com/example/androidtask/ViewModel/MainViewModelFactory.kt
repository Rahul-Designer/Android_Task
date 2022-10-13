package com.example.randomquote_retrofit_example.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidtask.Repository.JsonRepository

class MainViewModelFactory(private val jsonRepository: JsonRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(jsonRepository) as T
    }
}