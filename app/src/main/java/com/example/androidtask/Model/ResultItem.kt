package com.example.androidtask.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "json")
data class ResultItem(
    @PrimaryKey()
    val id: Int,
    val userId: Int,
    val title: String,
    val body: String
)