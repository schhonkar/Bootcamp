package com.example.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import com.google.firebase.perf.FirebasePerformance
import com.google.firebase.perf.metrics.AddTrace

class MainActivity : AppCompatActivity() {


    /**
     * For performance testing
     */
    val myTrace= FirebasePerformance.getInstance().newTrace("testTrace")


    private lateinit var firebaseAnalytics: FirebaseAnalytics

    @AddTrace(name = "OnCreateTrace")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        firebaseAnalytics = Firebase.analytics

        //Performance testing
        myFunction()



        /**
         * to get the data from cloud messaging in key value
         */
        Log.e("onCreate","${intent.extras?.getString("custom_data")}")
//        val button:Button = findViewById(R.id.button)
//        button.setOnClickListener {
////            throw RuntimeException("Test crash")
//            setUpUserProperty()
//            setUserId()
//            setDefaultParameters()
//            logEvent()
//
//        }

    }
    companion object {
        const val MY_PREFERENCES = "shared_pref"
        const val KEY = "Name"
        const val DESCRIPTION_KEY = "description_text"
    }


    /**
     * these are samples for practice during session
     * below are the samples
     */

//    private fun logEvent(){
//        // custom event
//        val eventName2 = "share_image"
//        val bundle = Bundle().apply {
//            putString("image_name", "some_name")
//            putString("image_description", "some_text")
//        }
//
//        firebaseAnalytics.logEvent(eventName2, bundle)
//    }
//
//    private fun setUpUserProperty() {
//        firebaseAnalytics.setUserProperty("location", "INDIA")
//        firebaseAnalytics.setUserProperty("currency", "INR")
//        firebaseAnalytics.setUserProperty("is_subscribe", "false")
//    }
//
//    private fun setDefaultParameters() {
//        val parameters = Bundle().apply {
//            putString(FirebaseAnalytics.Param.LOCATION, "INDIA")
//            putString(FirebaseAnalytics.Param.CURRENCY, "INR")
//        }
////        once this is called it can't be reset even you don't call the function so to reset we will send null
//        firebaseAnalytics.setDefaultEventParameters(parameters)
//        //to reset
////        firebaseAnalytics.setDefaultEventParameters(null)
//    }
//
//        private fun setUserId(){
//        firebaseAnalytics.setUserId("101")
//    }

    /**
     * Performance testing
     */
    private fun myFunction() {
        myTrace.start()

        myTrace.incrementMetric("hit",1)


        myTrace.stop()
    }
}