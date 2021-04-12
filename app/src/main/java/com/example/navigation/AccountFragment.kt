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
import kotlinx.android.synthetic.main.fragment_account.*


/**
 * A simple [Fragment] subclass.
 * Use the [AccountFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AccountFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        checkDataIsSaved()
        //To logout

        accountLogoutButton.setOnClickListener {
            if (checkString()){
                val pref =  activity?.getSharedPreferences(MainActivity.MY_PREFERENCES, Context.MODE_PRIVATE)
                val editor = pref?.edit()
                editor?.remove(MainActivity.KEY)
                editor?.commit()
                accountNameTextView.text = ""
                Toast.makeText(activity,"Data removed successfully",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun checkDataIsSaved(){
        if (checkString()) {
            accountNameTextView.text = getData()
        }
        else {
            Toast.makeText(activity, "Please save the name First", Toast.LENGTH_SHORT).show()
//            naviating to Login Fragment
            findNavController().navigate(R.id.action_global_loginFragment)
        }
    }

    private fun checkString():Boolean{
        val sharedPreferences = activity?.getSharedPreferences(MainActivity.MY_PREFERENCES, Context.MODE_PRIVATE)
        val name =  sharedPreferences?.getString(MainActivity.KEY, null)
//        Log.e("Splash","$name")
        return name != null
    }
    private fun getData():String{
        val sharedPreferences = activity?.getSharedPreferences(MainActivity.MY_PREFERENCES, Context.MODE_PRIVATE)
        return sharedPreferences?.getString(MainActivity.KEY, null).toString()
    }



}