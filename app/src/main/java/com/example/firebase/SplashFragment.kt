package com.example.navigation

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.firebase.MainActivity
import com.example.firebase.R
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase

/**
 * A simple [Fragment] subclass.
 * Use the [SplashFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SplashFragment : Fragment() {
    private var TIME_OUT:Long = 3000
    private lateinit var navController: NavController
    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        navController = findNavController()
        firebaseAnalytics = Firebase.analytics
        setDefaultParameter()
        logEvent()
        loadSplashScreen()
    }



    private fun loadSplashScreen(){
        Handler().postDelayed({
            // You can declare your desire activity here to open after finishing splash screen. Like MainActivity
            checkDataIsSaved()
        }, TIME_OUT)
    }

    private fun checkDataIsSaved(){
        if (checkString()){
            gotoHome()
        }
        else{
            gotoLogin()
        }

    }
    private fun gotoLogin(){
        val action = SplashFragmentDirections.actionSplashFragmentToLoginFragment()
        navController.navigate(action)
    }
    private fun gotoHome(){
      val action = SplashFragmentDirections.actionSplashFragmentToHomeFragment()
        navController.navigate(action)
    }

//    private fun getData():String{
//        val sharedPreferences = activity?.getSharedPreferences(MainActivity.MY_PREFERENCES, Context.MODE_PRIVATE)
//        return sharedPreferences?.getString(MainActivity.KEY, null).toString()
//    }

    /**
    *check if the data is saved in shared prefer
     *Return true is data is saved
     **/
    private fun checkString():Boolean{
        val sharedPreferences = activity?.getSharedPreferences(MainActivity.MY_PREFERENCES, Context.MODE_PRIVATE)
        val name =  sharedPreferences?.getString(MainActivity.KEY, null)
//        Log.e("Splash","$name")
        return name != null
    }

    /**
     * Get the data of the Shared Pref
     */
    private fun getSharedPref():String{
        val sharedPreferences = activity?.getSharedPreferences(MainActivity.MY_PREFERENCES, Context.MODE_PRIVATE)
        return sharedPreferences?.getString(MainActivity.KEY, null).toString()
    }

    /**
     * for Logevent for this Screen
     */
    private fun logEvent(){
        // custom event
        val eventName = "Splash_Screen"
        val bundle = Bundle().apply {
            if (checkString()){
                putString("Splash_screen","This is a Splash Screen")
                putString("user_name", getSharedPref())
            }
            else{
                putString("Splash_screen","This is a Splash Screen")
                putString("user_name", "no_user")
            }

        }
        firebaseAnalytics.logEvent(eventName,bundle)
//        firebaseAnalytics.logEvent(eventName2, bundle)
    }

    /**
     * Setting default parameters for splash screen
     */
    private fun setDefaultParameter(){
        var counter = 0
        val bundle = Bundle().apply {
            if (checkString()){
                putString("user_id", getSharedPref())
                counter++
            }
        }
        if (counter == 1){
            firebaseAnalytics.setDefaultEventParameters(bundle)
        }
        else{
            firebaseAnalytics.setDefaultEventParameters(null)
        }
    }

}