package com.example.storageapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_internal_storage.*
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.OutputStreamWriter

class InternalStorage : AppCompatActivity() {
    private val fileName = "myfile.txt"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_internal_storage)
        writefile()
        readfile()
    }

    private fun writefile(){
        bwrite.setOnClickListener {
            if(iedittext.text.toString().isNotEmpty()){
                try {
                    val fout:FileOutputStream = openFileOutput(fileName, MODE_PRIVATE)
                    fout.write(iedittext.text.toString().toByteArray())
                    fout.close()
                    Toast.makeText(applicationContext,"File saved",Toast.LENGTH_SHORT).show()
                    iedittext.setText("")
                }catch (e: Exception) {
                    e.printStackTrace()
                }
            }
            else{
                iedittext.error = "Please enter Name"
            }
        }
    }
    private fun readfile(){
        bread.setOnClickListener {
            try {
                val fin:FileInputStream = openFileInput(fileName)
                var c:Int
                var temp = ""
                while (fin.read().also { c = it } != -1){
                    temp += c.toChar().toString()
                }
                iedittext.setText(temp)
            }catch (e:java.lang.Exception){
                e.printStackTrace()
            }
        }
    }
}