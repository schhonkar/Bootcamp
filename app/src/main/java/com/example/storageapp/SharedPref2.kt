package com.example.storageapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_shared_pref2.*

class SharedPref2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_pref2)
        val pref = getPreferences(Context.MODE_PRIVATE)
        val key = "username"
        val keyCheck = "status"
        submitbutton.setOnClickListener {
            if(usredittext.text.toString().isNotEmpty() && pwdedittext.text.toString().isNotEmpty()){
                val editor = pref.edit()
                editor.putString(key,usredittext.text.toString())
                editor.putBoolean(keyCheck,true)
                editor.commit()
                usredittext.setText("")
                pwdedittext.setText("")
                Toast.makeText(applicationContext,"Data Saved",Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(applicationContext,"Please fill all the fields",Toast.LENGTH_SHORT).show()
            }
        }
        logoutbutton.setOnClickListener {
            if (pref.getBoolean(keyCheck,false)){
                val editor = pref.edit()
                editor.remove(key)
                editor.remove(keyCheck)
                editor.commit()
                usredittext.setText("")
                pwdedittext.setText("")
                Toast.makeText(applicationContext,"Data Removed successfully",Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(applicationContext,"No data is saved",Toast.LENGTH_SHORT).show()
            }
        }
        if (pref.getBoolean(keyCheck,false)){
            val usrname = pref.getString(key,"No values is saved")
            usredittext.setText(usrname)
        }
    }
}