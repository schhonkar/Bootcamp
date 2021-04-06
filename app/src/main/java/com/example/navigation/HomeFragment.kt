package com.example.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_home.*


/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    private lateinit var navController: NavController
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
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
                homeDescriptionView.text = it
            })

    }


}