package com.example.fragmentapp

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment_two.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment_two : Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("Fragment2","onAttach is called")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("Fragment2","onCreate is called")
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        Log.i("Fragment2","onCreateView is called")
        return inflater.inflate(R.layout.fragment_two, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.i("Fragment2","onActivityCreated is called")
    }

    override fun onStart() {
        super.onStart()
        Log.i("Fragment2","onStart is called")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Fragment2","onResume is called")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Fragment2","onPause is called")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Fragment2","onStop is called")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("Fragment2","onDestroyView is called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Fragment2","onDestroy is called")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i("Fragment2","onDetach is called")
    }



}