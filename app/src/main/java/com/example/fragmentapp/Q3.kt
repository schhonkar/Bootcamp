package com.example.fragmentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Q3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_q3)
        val but = findViewById<Button>(R.id.button1)
        but.setOnClickListener {
            var dialog = CustomDalogFragment()
            dialog.show(supportFragmentManager,"custom Dialog")
        }
        val but2 = findViewById<Button>(R.id.button2)
        but2.setOnClickListener {
            val intent = Intent(applicationContext,preference::class.java)
            startActivity(intent)
        }
    }
}