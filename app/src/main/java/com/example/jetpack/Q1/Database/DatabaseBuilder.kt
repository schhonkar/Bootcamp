package com.example.jetpack.Q1.Database

import android.content.Context
import androidx.room.Room

object DatabaseBuilder {

    private var INSTANCE:EmployeeRoomDatabase?=null




    fun  getInstance(context: Context):EmployeeRoomDatabase{
        if(INSTANCE == null)
        {
            synchronized(EmployeeRoomDatabase::class){
                INSTANCE= buildRoomDB(context)
            }
        }
        return INSTANCE!!
    }

    private fun buildRoomDB(context: Context)=
            Room.databaseBuilder(
                    context.applicationContext,
                    EmployeeRoomDatabase::class.java,
                    "Employee Database"
            ).fallbackToDestructiveMigration().build()

}