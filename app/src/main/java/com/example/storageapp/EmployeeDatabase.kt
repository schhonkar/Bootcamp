package com.example.storageapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person_table")
data class EmployeeDatabase(
        @PrimaryKey(autoGenerate = true)
        var id:Int = 0 ,
        @ColumnInfo(name = "name")
        var name:String? = null,
        @ColumnInfo(name = "Address")
        var address:String? = null,
        @ColumnInfo(name = "Number")
        var number:String? = null
)
