package com.example.firebase

import android.util.Log
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class FirebaseService:FirebaseMessagingService() {


    override fun onMessageReceived(p0: RemoteMessage) {
        super.onMessageReceived(p0)
        Log.d("Message Received","${p0.messageId}")

    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d("Token","$token")
    }
}