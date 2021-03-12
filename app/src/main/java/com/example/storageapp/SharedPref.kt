package com.example.storageapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_shared_pref.*

class SharedPref : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_pref)
        val pref = getPreferences(Context.MODE_PRIVATE)
        bsaveText.setOnClickListener {
            if (editText.text.toString().isNotEmpty()) {
                val editor = pref.edit()
                editor.putString("Name", editText.text.toString())
                editor.commit()
                Toast.makeText(applicationContext, "Data saved", Toast.LENGTH_SHORT).show()
            } else {
                editText.error = "Please enter the Name"
            }
        }
        bshowText.setOnClickListener {
            val name = pref.getString("Name","No value is saved")
            textView.text = name
        }
    }
}