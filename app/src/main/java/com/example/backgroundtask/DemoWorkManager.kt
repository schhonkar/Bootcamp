package com.example.backgroundtask

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters

class DemoWorkManager(context:Context,workerParameter:WorkerParameters):Worker(context,workerParameter) {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun doWork(): Result {
        notification("BackgroundTask","This is Demo WorkManager")
        return Result.success()
    }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun notification(title:String,desc:String){

        val notificationManager = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val notificationChannel = NotificationChannel("102", "channel",NotificationManager.IMPORTANCE_DEFAULT)
        notificationManager.createNotificationChannel(notificationChannel)

        val notificationBar = NotificationCompat.Builder(applicationContext, "102")
                .setContentTitle(title)
                .setContentText(desc)
                .setSmallIcon(R.drawable.ic_launcher_background)


        notificationManager.notify(1, notificationBar.build())

    }

}