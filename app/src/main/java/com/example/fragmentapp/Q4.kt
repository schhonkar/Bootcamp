package com.example.fragmentapp

import android.content.Context
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Surface
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class Q4 : AppCompatActivity(){

    private lateinit var manager: FragmentManager
    private lateinit var transaction: FragmentTransaction
    val listview = ListView()
    val detailview = DeatilsView()
    private val viewModel: ViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_q4)
        /*manager = supportFragmentManager
        if(findViewById<View?>(R.id.layout_default) != null){
            transaction = manager.beginTransaction()
            manager.findFragmentById(R.id.detailFrag)?.let { transaction.hide(it) }
            transaction.show(manager.findFragmentById(R.id.listFrag)!!)
            transaction.commit()
        }

       if(findViewById<View?>(R.id.layout_land)!= null){
           transaction = manager.beginTransaction()
           transaction.show(manager.findFragmentById(R.id.listFrag)!!)
           transaction.show(manager.findFragmentById(R.id.detailFrag)!!)
           transaction.commit()
       }*/


    }

    fun getRotation(context: Context): String {
        val rotation = (context.getSystemService(WINDOW_SERVICE) as WindowManager).defaultDisplay.orientation
        return when (rotation) {
            Surface.ROTATION_0 -> "portrait"
            Surface.ROTATION_90 -> "landscape"
            Surface.ROTATION_180 -> "reverse portrait"
            else -> "reverse landscape"
        }
    }

}