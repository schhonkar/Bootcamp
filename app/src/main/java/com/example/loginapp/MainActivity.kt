package com.example.loginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val usrName = findViewById<EditText>(R.id.username)
        val usrEmail = findViewById<EditText>(R.id.useremail)
        val usrNumber = findViewById<EditText>(R.id.usernumber)
        val usrpwd = findViewById<EditText>(R.id.userpwd)
        val button = findViewById<Button>(R.id.button)
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        button.setOnClickListener {
            if ((usrEmail.text.toString()).matches(emailPattern.toRegex()) && (usrpwd.text.toString().isNotEmpty()) && (usrNumber.text.toString()).length >= 10 && (usrName.text.toString()).isNotEmpty()){
                val intent = Intent(this,HomePage::class.java)
                val bundle = Bundle()
                bundle.putString("usrname",usrName.text.toString())
                bundle.putString("usremail",usrEmail.text.toString())
                bundle.putString("usrnumber",usrNumber.text.toString())
                intent.putExtras(bundle)
                startActivity(intent)
            }
            else{
                if (!(usrEmail.text.toString()).matches(emailPattern.toRegex())){
                    usrEmail.error = "Invalid Email"
                }
                if (!(usrName.text.toString()).isNotEmpty()){
                    usrName.error = "Enter user name"
                }
                if (!((usrNumber.text.toString()).length >= 10 )){
                    usrNumber.error = "Enter valid number"
                }
                if (!(usrpwd.text.toString().isNotEmpty())){
                    usrpwd.error = "Enter valid password"
                }

            }

        }


    }
}