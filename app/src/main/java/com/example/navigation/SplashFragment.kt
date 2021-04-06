package com.example.navigation

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

/**
 * A simple [Fragment] subclass.
 * Use the [SplashFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SplashFragment : Fragment() {
    private var TIME_OUT:Long = 3000
    private lateinit var navController: NavController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        navController = findNavController()
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

    private fun checkString():Boolean{
        val sharedPreferences = activity?.getSharedPreferences(MainActivity.MY_PREFERENCES, Context.MODE_PRIVATE)
        val name =  sharedPreferences?.getString(MainActivity.KEY, null)
//        Log.e("Splash","$name")
        return name != null
    }



}