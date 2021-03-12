package com.example.storageapp

import android.content.ContentProvider
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBaseHandler(context:Context):SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VERSION) {

    companion object {
        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "EmployeeDatabase"

        private const val TABLE_CONTACTS = "EmployeeTable"

        private val KEY_ID = "_id"
        private val KEY_NAME = "name"
        private val KEY_NUMBER = "Number"
        private val KEY_ADDRESS = "Address"
    }
        override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_CONTACTS_TABLE = ("CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_NUMBER + " TEXT," + KEY_ADDRESS + " TEXT" + ")")
        db?.execSQL(CREATE_CONTACTS_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // Drop older table if existed
        db?.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        // Create tables again
        onCreate(db)
    }

    fun addEmployee(emp:Model):Long{
        val db = this.writableDatabase
        val contentvalues = ContentValues()

        contentvalues.put(KEY_NAME,emp.name)
        contentvalues.put(KEY_NUMBER,emp.number)
        contentvalues.put(KEY_ADDRESS,emp.address)

        val success = db.insert(TABLE_CONTACTS,null,contentvalues)
        db.close()
        return success

    }
    fun viewEmployee():ArrayList<Model>{
        val emplist:ArrayList<Model> = ArrayList<Model>()
        val selectQuery = "SELECT * FROM $TABLE_CONTACTS"
        val db = this.readableDatabase
        var curser:Cursor? = null
        try {
            curser = db.rawQuery(selectQuery,null)
        }catch (e:SQLException){
            db.execSQL(selectQuery)
            return ArrayList()
        }
        var id:Int
        var name:String
        var number:String
        var address:String
        if(curser.moveToFirst()){
            do{
                id = curser.getInt(curser.getColumnIndex(KEY_ID))
                name = curser.getString(curser.getColumnIndex(KEY_NAME))
                number = curser.getString(curser.getColumnIndex(KEY_NUMBER))
                address = curser.getString(curser.getColumnIndex(KEY_ADDRESS))
                val emp = Model(id = id, name = name, number = number,address = address)
                emplist.add(emp)
            }while (curser.moveToNext())
        }
        return emplist
    }

    fun updateEmployee(emp:Model):Int{
        val db = this.writableDatabase
        val contentvalues = ContentValues()
        contentvalues.put(KEY_NAME,emp.name)
        contentvalues.put(KEY_NUMBER,emp.number)
        contentvalues.put(KEY_ADDRESS,emp.address)
        val success = db.update(TABLE_CONTACTS,contentvalues, KEY_ID + "=" + emp.id, null)
        db.close()
        return success
    }
    fun deleteEmployee(emp:Model):Int{
        val db = this.writableDatabase
        val contenvalues = ContentValues()
        contenvalues.put(KEY_ID,emp.id)
        val success = db.delete(TABLE_CONTACTS, KEY_ID + "=" + emp.id,null)

        db.close()
        return success
    }

}