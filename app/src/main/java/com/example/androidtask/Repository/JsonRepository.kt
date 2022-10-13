package com.example.androidtask.Repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.androidtask.DB.JsonDatabase
import com.example.androidtask.Model.ResultList
import com.example.androidtask.API.JsonService
import com.example.randomquote_retrofit_example.utils.NetworkUtils

class JsonRepository(
    private val jsonService: JsonService,
    private val jsonDatabase: JsonDatabase,
    private val applicationContext: Context
) {

    private val jsonLiveData = MutableLiveData<ResultList>()

    val jsonData: LiveData<ResultList>
        get() = jsonLiveData

    suspend fun getJsonData() {
        if (NetworkUtils.isInternetAvailable(applicationContext)) {
            val result = jsonService.getJsonData()
            if (result.body() != null) {
//                jsonDatabase.jsonDao().deleteJson()
//                jsonDatabase.jsonDao().addJson(result.body()!!.results)
                jsonLiveData.postValue(result.body())
            }
        } else {
            val json = jsonDatabase.jsonDao().getJson()
            jsonLiveData.postValue(ResultList(json))
        }

    }

}