package com.example.jetpack.Q2

import android.graphics.Color
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class ColorViewModel:ViewModel() {

    private var colorList = arrayListOf(
            Color.BLACK,
            Color.BLUE,
            Color.CYAN,
            Color.DKGRAY,
            Color.GREEN,
            Color.LTGRAY,
            Color.MAGENTA,
            Color.RED,
            Color.TRANSPARENT
    )
    var colorSelecter = colorList[0]

    fun getColor() {
        colorSelecter = colorList[Random.nextInt(0,colorList.size)]
    }
}