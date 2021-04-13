package com.example.testing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        checkBox.setChecked(true)


        button.setOnClickListener {
            if (getCheckButtonStatus()){
                    checkBox.setChecked(false)
            }
            else{

                checkBox.setChecked(true)
            }
        }

    }

    fun getCheckButtonStatus():Boolean{
        if (checkBox.isChecked){
            return true
        }
        else{
            return false
        }
    }


    /**
     * Email validation
     */
    fun isEmailValid(email: String): Boolean {
        if (!email.contains("@"))
            return false
        else if (email.contains(" "))

        return false
        else if (!email.contains("gmail.com"))
            return false
        else if (email.contains("-"))
            return false
        else if(email.startsWith("_"))
            return false
        return true
    }

}