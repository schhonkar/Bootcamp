package com.example.jetpack.q1.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.jetpack.q1.EmployeeData


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