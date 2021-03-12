package com.example.storageapp

import android.content.Context
import androidx.room.Room

class RoomDatabaseBuilder {


    private var INSTANCE: AppRoomDatabase? = null

    fun getInstance(context: Context): AppRoomDatabase {
        if (INSTANCE == null) {
            synchronized(AppRoomDatabase::class) {
                INSTANCE = buildRoomDB(context)
            }
        }
        return INSTANCE!!
    }

    private fun buildRoomDB(context: Context) =
        Room.databaseBuilder(
            context.applicationContext,
            AppRoomDatabase::class.java,
            "roomdbexample"
        ).fallbackToDestructiveMigration().build()
}