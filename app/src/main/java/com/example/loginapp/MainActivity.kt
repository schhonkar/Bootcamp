package com.example.loginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val et_user_name = findViewById(R.id.username) as EditText
        val et_password = findViewById(R.id.password) as EditText
        val btn_submit = findViewById(R.id.login) as Button
        btn_submit.setOnClickListener {
            if ((et_user_name.text.toString()).isEmpty() or (et_password.text.toString()).isEmpty()) {
                et_user_name.error = "Please enter email"
                et_password.error = "Please enter the password"
            } else {
                val intent = Intent(this@MainActivity, HomePage::class.java)
                startActivity(intent)

            }
        }
    }



}