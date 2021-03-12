package com.example.storageapp

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = arrayOf(EmployeeDatabase::class),version = 3)
abstract class AppRoomDatabase: RoomDatabase() {
    abstract fun empDao():EmployeeDao
}