package com.example.navigation

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_update_dialog.*


/**
 * A simple [Fragment] subclass.
 * Use the [UpdateDialogFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UpdateDialogFragment : DialogFragment() {

    private lateinit var navController: NavController
    val args:UpdateDialogFragmentArgs by navArgs()
    lateinit var description:EditText

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        navController = findNavController()
        val title = args.dialogfragmentTitle
        val builder = AlertDialog.Builder(requireContext())
        val inflater = requireActivity().layoutInflater


        val dialogLayout = inflater.inflate(R.layout.fragment_update_dialog,null)
        description = dialogLayout.findViewById(R.id.updateDialogEditDescriptionText)
            return builder
            .setView(dialogLayout)
            .setCancelable(false)
            .setTitle(title)
            .setPositiveButton("Add"){
                dialog,which ->
                getDescription()
            }
            .create()

    }

    private fun getDescription(){
        if(description.text.toString().isNotEmpty()){
            navController.previousBackStackEntry?.savedStateHandle?.set(
                MainActivity.DESCRIPTION_KEY,description.text.toString()
            )
        }
        else{
            navController.previousBackStackEntry?.savedStateHandle?.set(
                MainActivity.DESCRIPTION_KEY,"Please Enter the Description")
            Toast.makeText(context,"Please Enter the Description",Toast.LENGTH_SHORT).show()
//            updateDialogEditDescriptionText.error = "Please enter the description"
        }
    }


//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
//                              savedInstanceState: Bundle?): View? {
//
//        val view = inflater.inflate(R.layout.fragment_update_dialog, container, false)
//        val title = args.dialogfragmentTitle
//        Log.i("itle","$title")
//        view.findViewById<TextView>(R.id.updateDialogTitleTextView).text = title
//
//        return view
//    }


}