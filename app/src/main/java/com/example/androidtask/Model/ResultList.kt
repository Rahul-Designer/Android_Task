package com.example.androidtask.Model

import com.google.gson.annotations.SerializedName

data class ResultList(
    @SerializedName("result")
    val results: List<ResultItem>
)