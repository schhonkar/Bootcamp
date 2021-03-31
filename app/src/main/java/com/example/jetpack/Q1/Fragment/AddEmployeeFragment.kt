package com.example.jetpack.Q1.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.jetpack.Q1.Database.EmployeeData
import com.example.jetpack.Q1.RoomMainActivity
import com.example.jetpack.Q1.VewModel.EmployeeViewModel
import com.example.jetpack.R
import kotlinx.android.synthetic.main.fragment_add_employee.*
import java.util.concurrent.Executors


/**
 * A simple [Fragment] subclass.
 * Use the [AddEmployeeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddEmployeeFragment : Fragment() {
    lateinit var model:EmployeeViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_employee, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        saveButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val number = numberEditText.text.toString()
            val address = emailEditText.text.toString()
            addData(name,number,address)
            Toast.makeText(activity!!.application, "Data Added successfully", Toast.LENGTH_SHORT).show()
            fragmentManager?.popBackStack()
        }

    }
    private fun addData( name:String, number:String,address:String) {

            model = ViewModelProvider(this).get(EmployeeViewModel(activity!!.application)::class.java)
            if(nameEditText.text.toString().isNotEmpty() && emailEditText.text.toString().isNotEmpty() && numberEditText.text.toString().isNotEmpty()){
               val employee = EmployeeData(0,name,number,address)
                model.addDataEmployee(employee)
            }
            else{
                if (nameEditText.text.toString().isEmpty()){
                    nameEditText.error = "Please Enter the Name"
                }
                if(emailEditText.text.toString().isEmpty()){
                    emailEditText.error = "Please Enter the Email Properly"
                }
                if(numberEditText.text.toString().isEmpty()){
                    numberEditText.error = "Please the number"
                }
            }



    }
}