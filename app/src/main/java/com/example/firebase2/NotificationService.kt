package com.example.firebase2

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class NotificationService:FirebaseMessagingService() {

    companion object {
        const val IMAGE_URL_KEY = "image_url"
    }
    override fun onMessageReceived(p0: RemoteMessage) {
        super.onMessageReceived(p0)

        //To print the message id or we can check if the message is working or not

//        Log.i("Notification Service", "Message ID" + p0.messageId.toString())

        p0.notification?.let {
            //Log.d(TAG, "Message Notification Body: ${it.body}")
            getNotification(it.title, it.body, p0.data)
        }

    }

    private fun getNotification(title: String?, body: String?, data: MutableMap<String, String>){

        val intent = Intent(this,MainActivity::class.java)
        intent.putExtra(IMAGE_URL_KEY,data[IMAGE_URL_KEY])
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingIntent = PendingIntent.getActivity(
                this, 0 /* Request code */, intent,
                PendingIntent.FLAG_UPDATE_CURRENT
        )
        val channelId = getString(R.string.default_notification_channel_id)
        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val notificationBuilder = NotificationCompat.Builder(this, channelId)
                .setSmallIcon(R.drawable.ic_baseline_add_alert_24)
                .setContentTitle(title)
                .setContentText(body)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent)

        val notificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // Since android Oreo notification channel is needed.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                    channelId,
                    getString(R.string.channel_name),
                    NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationManager.createNotificationChannel(channel)
        }
        // Show notification
        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build())


    }
}