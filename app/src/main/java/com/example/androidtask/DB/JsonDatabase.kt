package com.example.androidtask.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.androidtask.Model.ResultItem

@Database(entities = [ResultItem::class], version = 1)
abstract class JsonDatabase : RoomDatabase() {
    abstract fun jsonDao(): JsonDao

    companion object {
        @Volatile
        private var INSTANCE: JsonDatabase? = null

        fun getDatabase(context: Context): JsonDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        JsonDatabase::class.java, "JsonDB"
                    ).build()
                }
            }
            return INSTANCE!!
        }
    }
}