package com.example.jetpack.Q1.Dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.example.jetpack.Q1.Database.EmployeeData


@Dao
interface EmployeeDao {
    @Query("Select * from Employee_table")
    fun getAllData(): LiveData<List<EmployeeData>>
    @Insert
    fun insertData(data: EmployeeData)
    @Update
    fun updateData(data: EmployeeData)
    @Delete
    fun deleteData(data: EmployeeData)
}