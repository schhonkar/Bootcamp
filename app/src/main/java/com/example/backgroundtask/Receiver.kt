package com.example.backgroundtask

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_receiver.*

class Receiver : AppCompatActivity() {
    private var checkBattery: BroadcastReceiver = BatteryCheck()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receiver)
        batteryCheck.setOnClickListener {
            broadcastReceiver()
        }
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(checkBattery)
    }
    private fun broadcastReceiver() {
        // Dynamic registration of Broadcast receiver
        checkBattery = BatteryCheck()
        registerReceiver(checkBattery, IntentFilter(Intent.ACTION_BATTERY_CHANGED))
        if (ContextCompat.checkSelfPermission(
                        this,
                        android.Manifest.permission.READ_PHONE_STATE
                )
                != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.READ_PHONE_STATE), 1
            );
        }
    }
}