package com.example.webservices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.webservices.Q1.Q1
import com.example.webservices.Q2.Q2
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        q1.setOnClickListener {
            startActivity(Intent(this, Q1::class.java))
        }

        q2.setOnClickListener {
            startActivity(Intent(this, Q2::class.java))
        }
    }
}