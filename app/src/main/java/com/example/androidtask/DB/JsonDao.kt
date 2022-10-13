package com.example.androidtask.DB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.androidtask.Model.ResultItem

@Dao
interface JsonDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addJson( json : List<ResultItem>)

    //Read Data from Database
    @Query("SELECT * FROM json")
    suspend fun getJson() : List<ResultItem>

    @Query("DELETE From json")
    suspend fun deleteJson()
}