package com.example.backgroundtask

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.widget.Toast


class Music: Service() {
    lateinit var  mediaPlayer:MediaPlayer
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        Toast.makeText(this,"Service Started",Toast.LENGTH_SHORT).show()
        mediaPlayer = MediaPlayer.create(applicationContext, R.raw.song)
        mediaPlayer.isLooping = false
    }

    override fun onStart(intent: Intent?, startId: Int) {
        Toast.makeText(this, "Service started", Toast.LENGTH_SHORT).show()
        mediaPlayer.start()
    }

    override fun onDestroy() {
        Toast.makeText(this, "service stopped", Toast.LENGTH_SHORT).show()
        mediaPlayer.stop()
    }

}