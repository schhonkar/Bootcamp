package com.example.backgroundtask

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import java.text.SimpleDateFormat
import java.util.*

class BindService:Service() {
    private val myBinder = MyLocalBinder()
    override fun onBind(intent: Intent?): IBinder? {
        return myBinder
    }
    class MyLocalBinder: Binder() {
        fun getService(): BindService {
            return BindService()
        }
    }
    fun getCurrentTime(): String {
        val dateformat = SimpleDateFormat("MM/dd/yyyy HH:mm:ss",
                Locale.US)
        return dateformat.format(Date())
    }

}