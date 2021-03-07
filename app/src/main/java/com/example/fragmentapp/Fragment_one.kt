package com.example.fragmentapp

import android.content.Context
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup



/**
 * A simple [Fragment] subclass.
 * Use the [Fragment_one.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment_one : Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("Fragment1","onAttach is called")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("Fragment1","onCreate is called")
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("Fragment1","onCreateView is called")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.i("Fragment1","onActivityCreated is called")
    }

    override fun onStart() {
        super.onStart()
        Log.i("Fragment1","onStart is called")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Fragment1","onResume is called")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Fragment1","onPause is called")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Fragment1","onStop is called")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("Fragment1","onDestroyView is called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Fragment1","onDestroy is called")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i("Fragment1","onDetach is called")
    }




}