package com.example.backgroundtask

import android.content.Context
import android.util.Log
import android.widget.Toast
import java.lang.Exception

class CustomThread2(val context: Context):Thread() {
    override fun run() {
        super.run()

        for (i in 0..5) {
            Log.i("Thread-2", "is running, Iteration: $i")
        }

        try {
            Thread.sleep(500)
        }
        catch (e: Exception) {
            Toast.makeText(context, "Exception", Toast.LENGTH_SHORT).show()
        }
    }
}