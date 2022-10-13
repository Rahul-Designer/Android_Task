package com.example.androidtask.API

import com.example.androidtask.Model.ResultList
import retrofit2.Response
import retrofit2.http.GET

interface JsonService {
    @GET("/posts")
    suspend fun getJsonData(): Response<ResultList>
}