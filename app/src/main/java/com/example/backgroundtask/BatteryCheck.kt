package com.example.backgroundtask

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BatteryCheck:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val checkPercentage = intent?.getIntExtra("level", 0)
        if(checkPercentage != 0){
            Toast.makeText(context, "Batter percentage " + checkPercentage.toString() + "%", Toast.LENGTH_SHORT).show()
        }
    }
}