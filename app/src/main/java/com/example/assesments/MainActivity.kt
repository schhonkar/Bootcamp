package com.example.assesments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val logButton = findViewById<Button>(R.id.logButton)
        logButton.setOnClickListener {
            val intent = Intent(this,LoginPage::class.java)
            startActivity(intent)
        }
        val imgButton1 = findViewById<Button>(R.id.secButton)
        imgButton1.setOnClickListener {
            val intent = Intent(this,Restaurants::class.java)
            startActivity(intent)
        }
        val imgButton2 = findViewById<Button>(R.id.thiButton)
        imgButton2.setOnClickListener {
            val intent = Intent(this,ConstraintLayout::class.java)
            startActivity(intent)
        }
        val layout1 = findViewById<Button>(R.id.layButton)
        layout1.setOnClickListener {
            val intent = Intent(this,LayoutPart1::class.java)
            startActivity(intent)
        }
        val pagin = findViewById<Button>(R.id.pagbutton)
        pagin.setOnClickListener {
            val intent = Intent(this,Paging::class.java)
            startActivity(intent)
        }
    }
}