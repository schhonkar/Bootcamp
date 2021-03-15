package com.example.backgroundtask

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.TelephonyManager
import android.widget.Toast
import java.lang.Exception

class IncomingCall: BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
//        try {
//            var state = intent?.getStringExtra(TelephonyManager.EXTRA_STATE)
//            if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)){
//                Toast.makeText(context,"Phone is ringing",Toast.LENGTH_SHORT).show()
//            }
//            if(state.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)){
//                Toast.makeText(context,"Call Received",Toast.LENGTH_SHORT).show()
//            }
//        }catch (e:Exception){
//            e.printStackTrace()
//        }

        if (intent?.getStringExtra(TelephonyManager.EXTRA_STATE)
                        .equals(TelephonyManager.EXTRA_STATE_RINGING)
        ) {
            showMessage(context, "Your Phone is ringing");
        }
    }

    private fun showMessage(context: Context?, message: String) {
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show()

    }

}