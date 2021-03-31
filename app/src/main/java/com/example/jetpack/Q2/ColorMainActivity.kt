package com.example.jetpack.Q2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProvider
import com.example.jetpack.R
import kotlinx.android.synthetic.main.activity_color_main.*

class ColorMainActivity : AppCompatActivity() {

    lateinit var model: ColorViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_main)

        model = ViewModelProvider(this).get(ColorViewModel::class.java)
        changeClickListner()

    }

    override fun onResume() {
        super.onResume()
        colorMainLayout.setBackgroundColor(model.colorSelecter)
    }
    private fun changeClickListner(){
        changeColorButton.setOnClickListener {
            model.getColor()
            colorMainLayout.setBackgroundColor(model.colorSelecter)
        }
    }
}