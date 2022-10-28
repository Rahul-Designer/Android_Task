package com.example.androidtask.Repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.androidtask.API.JsonService
import com.example.androidtask.DB.JsonDatabase
import com.example.androidtask.Model.ResultItem
import com.example.randomquote_retrofit_example.utils.NetworkUtils

class JsonRepository(
    private val jsonService: JsonService,
    private val jsonDatabase: JsonDatabase,
    private val applicationContext: Context
) {

    private val jsonLiveData = MutableLiveData<List<ResultItem>>()

    val jsonData: LiveData<List<ResultItem>>
        get() = jsonLiveData

    suspend fun getJsonData() {
        if (NetworkUtils.isInternetAvailable(applicationContext)) {
            val result = jsonService.getJsonData()
            if (result.body() != null) {
                jsonDatabase.jsonDao().addJson(result.body()!!)
                jsonLiveData.postValue(result.body())
            }
        } else {
            val json = jsonDatabase.jsonDao().getJson()
            jsonLiveData.postValue(json)
        }

    }

}