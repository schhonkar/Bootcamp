package com.example.jetpack.q1.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.jetpack.q1.Dao.EmployeeDao
import com.example.jetpack.q1.EmployeeData


@Database(entities = arrayOf(EmployeeData::class),version = 1)
abstract class EmployeeRoomDatabase:RoomDatabase() {
    abstract fun empDao(): EmployeeDao

//    companion object{
//        private var INSTANCE: EmployeeRoomDatabase? = null
//
//        fun getDatabase(context: Context): EmployeeRoomDatabase {
//
//            if (INSTANCE == null) {
//                synchronized(EmployeeRoomDatabase::class) {
//                    INSTANCE = buildRoomDB(context)
//
//                }
//            }
//            return INSTANCE!!
//        }
//        private fun buildRoomDB(context: Context) =
//                Room.databaseBuilder(
//                        context.applicationContext,
//                        EmployeeRoomDatabase::class.java,
//                        "EmployeeRoomDatabase"
//                ).fallbackToDestructiveMigration().build()
//
//        fun destroyInstance() {
//            INSTANCE = null
//        }
//    }
}