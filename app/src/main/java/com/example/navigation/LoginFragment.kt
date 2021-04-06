package com.example.navigation

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        //ClickListner to go to Home Fragment

            view.findViewById<Button>(R.id.loginButton).setOnClickListener {
                if(loginEditText.text.toString() != ""){
                    val name = loginEditText.text.toString()
                    saveInSharedPrefernece(name)
                    Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_homeFragment)
                    loginEditText.setText("")
                }
                else{
                    loginEditText.error = "Please enter the name"
                }
            }
        return view
    }

    private fun saveInSharedPrefernece(name:String){
        val sharedPreferences = activity?.getSharedPreferences(MainActivity.MY_PREFERENCES,Context.MODE_PRIVATE)
        val editor = sharedPreferences?.edit()
        editor?.putString(MainActivity.KEY,name)
        editor?.apply()
    }





}