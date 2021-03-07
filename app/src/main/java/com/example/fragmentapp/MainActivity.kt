package com.example.fragmentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    private lateinit var manager: FragmentManager
    private lateinit var transaction: FragmentTransaction
    val fragment = Fragment_one()
    val fragment2 = Fragment_two()
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.e("Activity","onCreate is called")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val q3 = findViewById<Button>(R.id.gotoq3)
        q3.setOnClickListener {
            val intent = Intent(this,Q3::class.java)
            startActivity(intent)
        }
        val q4 = findViewById<Button>(R.id.gotoQ4)
        q4.setOnClickListener {
            val intent = Intent(this,Q4::class.java)
            startActivity(intent)
        }
        val add = findViewById<Button>(R.id.addButton)
        val remove = findViewById<Button>(R.id.remButton)
        val replace = findViewById<Button>(R.id.repButton)
        val hide = findViewById<Button>(R.id.hideButton)
        val show = findViewById<Button>(R.id.showButton)
        var activeFragment:Boolean = true
        manager = supportFragmentManager
        add.setOnClickListener {

            if (manager.findFragmentById(R.id.fragmentHolder) == null){
                transaction = manager.beginTransaction()
                transaction.add(R.id.fragmentHolder,fragment)
                transaction.commit()
                Log.i("Adding","Addding fragment")
            }
            else{
                Toast.makeText(applicationContext,"Fragment is already added",Toast.LENGTH_SHORT).show()

            }

        }

        remove.setOnClickListener {
            val fragm = manager.findFragmentById(R.id.fragmentHolder)
            if (supportFragmentManager.findFragmentById(R.id.fragmentHolder) != null) {
                transaction =manager.beginTransaction()
                if (fragm != null) {
                    transaction.remove(fragm)
                }

                transaction.commit()
                Log.i("Remove","Removing fragment")
            }
        }

        replace.setOnClickListener {
            if (activeFragment){
                changeFragment(fragment2)
                activeFragment=false
                Log.i("Replace","Replacing fragment")
            }
            else {
                changeFragment(fragment)
                activeFragment = true
                Log.i("Replace","Replacing fragment")

            }

        }

        hide.setOnClickListener {
            val fragm = manager.findFragmentById(R.id.fragmentHolder)
            if (fragm != null) {
                transaction =manager.beginTransaction()
                transaction.hide(fragm)
                transaction.commit()
                Log.i("Hide","Hiding fragment")
            }
        }
        show.setOnClickListener {
            val fragm = manager.findFragmentById(R.id.fragmentHolder)
            if (fragm != null) {
                transaction =manager.beginTransaction()
                transaction.show(fragm)
                transaction.commit()
                Log.i("Show","Showing fragment")
            }
        }

    }


    override fun onStart() {
        super.onStart()
        Log.e("Activity","onStart is called")
    }

    override fun onResume() {
        super.onResume()
        Log.e("Activity","onResume is called")
    }

    override fun onPause() {
        super.onPause()
        Log.e("Activity","onPause is called")
    }

    override fun onStop() {
        super.onStop()
        Log.e("Activity","onStop is called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("Activity","onDestroy is called")
    }
    private fun changeFragment(fragment: Fragment){
        transaction = manager.beginTransaction()
        transaction.replace(R.id.fragmentHolder,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}