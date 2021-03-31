package com.example.jetpack.Q1.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Employee_table")
data class EmployeeData(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    @ColumnInfo(name = "Name")
    val name:String? = null,
    @ColumnInfo(name = "Email")
    val email:String? = null,
    @ColumnInfo(name = "Number")
    val number:String? = null
)
