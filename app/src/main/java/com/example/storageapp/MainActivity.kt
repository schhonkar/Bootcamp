package com.example.storageapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //defining action for shared Preference button
        sharedPref.setOnClickListener {
            val intent = Intent(this,SharedPref::class.java)
            startActivity(intent)

        }
        internalStorage.setOnClickListener {
            val intent = Intent(this,InternalStorage::class.java)
            startActivity(intent)
        }
        sqlite.setOnClickListener {
            val intent = Intent(this,SqlLite::class.java)
            startActivity(intent)
        }
        roomdb.setOnClickListener {
            val intent = Intent(this,RoomDataBase::class.java)
            startActivity(intent)
        }
        sharedPref2.setOnClickListener {
            val intent = Intent(this,SharedPref2::class.java)
            startActivity(intent)
        }
        loadContacts.setOnClickListener {
            val intent = Intent(this,SqlLite::class.java)
            startActivity(intent)
        }
    }
}