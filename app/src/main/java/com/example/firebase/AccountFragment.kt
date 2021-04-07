package com.example.navigation

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.firebase.MainActivity
import com.example.firebase.R
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_account.*
import java.lang.RuntimeException


/**
 * A simple [Fragment] subclass.
 * Use the [AccountFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AccountFragment : Fragment() {

    private lateinit var firebaseAnalytics: FirebaseAnalytics
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //Initializing Analytics
        firebaseAnalytics = Firebase.analytics
        checkDataIsSaved()
        logEvent()
    }

    private fun checkDataIsSaved(){
        if (checkString()) {
            accountNameTextView.text = getData()
        }
        else {
//            Toast.makeText(activity, "Please save the name First", Toast.LENGTH_SHORT).show()
////            naviating to Login Fragment
//            findNavController().navigate(R.id.action_global_loginFragment)
            /**
             * Crashing if data is not saved
             */
            throw RuntimeException("Account Screen Crashed")
        }
    }

    private fun checkString():Boolean{
        val sharedPreferences = activity?.getSharedPreferences(MainActivity.MY_PREFERENCES, Context.MODE_PRIVATE)
        val name =  sharedPreferences?.getString(MainActivity.KEY, null)
        Log.e("Splash","$name")
        return name != null
    }
    private fun getData():String{
        val sharedPreferences = activity?.getSharedPreferences(MainActivity.MY_PREFERENCES, Context.MODE_PRIVATE)
        return sharedPreferences?.getString(MainActivity.KEY, null).toString()
    }


    /**
     * Log Event
     */
    private fun logEvent(){
        // custom event
        val eventName = "Account_Screen"
        val bundle = Bundle().apply {
            putString("Account_Screen","This is a Account Screen")

        }
        firebaseAnalytics.logEvent(eventName,bundle)
    }



}