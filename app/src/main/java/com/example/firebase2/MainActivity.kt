package com.example.firebase2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageURL = getCustomDataFromFCM()
        if (imageURL != null) {
            updateUI(imageURL)
        } else {
            Toast.makeText(this, "Make sure notification has correct image URL", Toast.LENGTH_SHORT)
                    .show()
        }
    }

    private fun updateUI(imageURL: String) {
        Glide
                .with(this)
                .load(imageURL)
                .into(imageView)



    }

    private fun getCustomDataFromFCM(): String? {
        Log.i("MainActivity", "${ intent.extras?.getString(NotificationService.IMAGE_URL_KEY) }")
        return intent.extras?.getString(NotificationService.IMAGE_URL_KEY)
    }
}