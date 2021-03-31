package com.example.jetpack.Q1.VewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetpack.Q1.Database.DatabaseBuilder
import com.example.jetpack.Q1.Database.EmployeeData
import com.example.jetpack.Q1.Database.EmployeeRoomDatabase
import java.util.concurrent.Executors

class EmployeeViewModel(application: Application):AndroidViewModel(application) {

    val allData:MutableLiveData<List<EmployeeData>> = MutableLiveData()
    private val context = getApplication<Application>().applicationContext
    private val roomDatabaseBuilder = DatabaseBuilder.getInstance(context)

    fun getAllDetails():LiveData<List<EmployeeData>>{
        return roomDatabaseBuilder.empDao().getAllData()
    }

    fun addDataEmployee(data:EmployeeData){
        Executors.newSingleThreadExecutor().execute {
            roomDatabaseBuilder.empDao().insertData(
                EmployeeData(
                    id = data.id,
                    name = data.name,
                    email = data.email,
                    number = data.number
                )
            )
        }
    }

}