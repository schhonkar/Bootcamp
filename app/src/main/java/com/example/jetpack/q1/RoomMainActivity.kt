package com.example.jetpack.q1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jetpack.q1.Fragment.DisplayDataFragment
import com.example.jetpack.R

class RoomMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_main)


        addFragmentView()
    }
    private fun addFragmentView(){
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.add(R.id.fragmentContainerView,DisplayDataFragment())
        transaction.commit()
    }

}