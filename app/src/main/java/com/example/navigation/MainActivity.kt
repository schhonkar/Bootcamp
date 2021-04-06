package com.example.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    companion object {
        const val MY_PREFERENCES = "shared_pref"
        const val KEY = "Name"
        const val DESCRIPTION_KEY = "description_text"
    }
}