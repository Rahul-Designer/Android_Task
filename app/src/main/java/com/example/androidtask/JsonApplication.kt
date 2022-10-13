package com.example.androidtask

import android.app.Application
import com.example.androidtask.DB.JsonDatabase
import com.example.androidtask.API.JsonService
import com.example.androidtask.API.RetrofitHelper
import com.example.androidtask.Repository.JsonRepository

class JsonApplication : Application() {
    lateinit var jsonRepository: JsonRepository

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val quoteService = RetrofitHelper.getInstance().create(JsonService::class.java)
        val database = JsonDatabase.getDatabase(applicationContext)
        jsonRepository = JsonRepository(quoteService, database, applicationContext)
    }
}