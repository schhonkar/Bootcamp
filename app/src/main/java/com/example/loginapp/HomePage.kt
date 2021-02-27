package com.example.loginapp

import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class HomePage : AppCompatActivity() {
    val camere_rq = 102
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        val susrname = findViewById<TextView>(R.id.susrname)
        val susremail = findViewById<TextView>(R.id.susremail)
        val susrnumber = findViewById<TextView>(R.id.susrNumber)
        val bundle1 = intent.extras
        val datausrname = bundle1?.get("usrname")
        val datausremail = bundle1?.get("usremail")
        val datausrnumber = bundle1?.get("usrnumber")
        susrname.setText("Name: $datausrname")
        susremail.setText("Email: $datausremail")
        susrnumber.setText("Number: $datausrnumber")

        val srhButton = findViewById<Button>(R.id.search)
        val takeUrl = findViewById<EditText>(R.id.searchingUrl)
        srhButton.setOnClickListener {
            if (takeUrl.text.toString().isNotEmpty()){
                val intentUrl = Intent(Intent.ACTION_VIEW)
                intentUrl.data = Uri.parse(takeUrl.text.toString())
                startActivity(intentUrl)
            }
            else{
                Toast.makeText(applicationContext,"Please enter the url",Toast.LENGTH_SHORT).show()
            }

        }
        val cameraPer = findViewById<Button>(R.id.btn_camera)
        cameraPer.setOnClickListener {
            checkForPermission(android.Manifest.permission.CAMERA,camere_rq)
        }
    }
    private fun checkForPermission(permission: String,requestCode:Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            when{
                ContextCompat.checkSelfPermission(applicationContext,permission) == PackageManager.PERMISSION_GRANTED ->{
                    Toast.makeText(applicationContext,"Permission Granted",Toast.LENGTH_SHORT).show()
                }
                shouldShowRequestPermissionRationale(permission) -> Toast.makeText(applicationContext,"Please provide the permission from setting",Toast.LENGTH_SHORT).show()
            else -> ActivityCompat.requestPermissions(this, arrayOf(permission),requestCode)
        }
    }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        fun innerCheck(){
            if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED){
                Toast.makeText(applicationContext,"Permission Refused",Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(applicationContext,"Permission Granted",Toast.LENGTH_SHORT).show()
            }
        }
        when(requestCode){
            camere_rq -> innerCheck()
        }
    }
}