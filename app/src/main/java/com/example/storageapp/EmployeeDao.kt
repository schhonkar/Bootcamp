package com.example.storageapp

import androidx.room.*


@Dao
interface EmployeeDao {
    @Query("Select * from person_table")
    fun getAllPerson():List<EmployeeDatabase>

    @Insert
    fun insertPerson(person: EmployeeDatabase)

    @Update
    fun updatePerson(person: EmployeeDatabase)

    @Delete
    fun deletePerson(person: EmployeeDatabase)

    @Query("DELETE from person_table WHERE name = :ID" )
    fun deletebyID(ID:Int)

}