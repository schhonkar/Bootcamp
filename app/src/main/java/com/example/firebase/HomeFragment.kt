package com.example.navigation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.firebase.MainActivity
import com.example.firebase.R
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_home.*


/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    private lateinit var firebaseAnalytics: FirebaseAnalytics

    private lateinit var navController: NavController
    lateinit var description:String
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        description = view.findViewById<TextView>(R.id.homeDescriptionView).text.toString()
        Log.e("Description","${description}")
        //To open Account Fragment
        homeGotoAccountButton.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_accountFragment)
        }
        //update Dialog Button
        homeAddDescriptionButton.setOnClickListener {
            if(homeEditTextTitle.text.toString().isNotEmpty()){
                val title = homeEditTextTitle.text.toString()
                val action = HomeFragmentDirections.actionHomeFragmentToUpdateDialogFragment2(title)
                navController.navigate(action)
//                Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_updateDialogFragment2)
            }
            else{
                homeEditTextTitle.error = "Please Enter the title"
            }
        }

        //adding data in description TextView
        navController.currentBackStackEntry?.savedStateHandle?.getLiveData<String>(MainActivity.DESCRIPTION_KEY)
            ?.observe(viewLifecycleOwner, Observer {
//                homeDescriptionView.text = it

                updateUi(it)
            })



    }

    fun updateUi(description1:String){
        if (description != description1){
            homeDescriptionView.text = description1
            logEvent1()
        }

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        firebaseAnalytics = Firebase.analytics
        logEvent()
    }

    private fun logEvent(){
        // custom event
        val eventName = "Home_Screen"
        val bundle = Bundle().apply {
            putString("Home_Screen","This is a Home Screen")

        }
        firebaseAnalytics.logEvent(eventName,bundle)
    }


//    override fun onResume() {
//        super.onResume()
//        if(description == homeDescriptionView.text.toString()){
//                logEvent1()
//        }
//    }
    private fun logEvent1(){
        // custom event
        val eventName = "Home_Screen_Description"
        val bundle = Bundle().apply {
            putString("Home_Screen_Description","Data Changed")

        }
        firebaseAnalytics.logEvent(eventName,bundle)
    }

}