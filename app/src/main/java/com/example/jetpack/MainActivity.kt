package com.example.jetpack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.jetpack.Q1.RoomMainActivity
import com.example.jetpack.Q2.ColorMainActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button1 = findViewById<Button>(R.id.q1)
        button1.setOnClickListener {
            val intent = Intent(this,RoomMainActivity::class.java)
            startActivity(intent)
        }
        val button2 = findViewById<Button>(R.id.q2)
        button2.setOnClickListener {
            val intent = Intent(this,ColorMainActivity::class.java)
            startActivity(intent)
        }
    }
}