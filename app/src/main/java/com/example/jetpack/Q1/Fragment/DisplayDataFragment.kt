package com.example.jetpack.Q1.Fragment

import android.os.Build.VERSION_CODES.O
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpack.Q1.Adapter.EmployeeAdopter
import com.example.jetpack.Q1.Database.EmployeeData
import com.example.jetpack.Q1.VewModel.EmployeeViewModel
import com.example.jetpack.R
import kotlinx.android.synthetic.main.fragment_display_data.*


/**
 * A simple [Fragment] subclass.
 * Use the [DisplayDataFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DisplayDataFragment : Fragment() {

    private lateinit var myAdapter:EmployeeAdopter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_display_data, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        floatingButton.setOnClickListener {
            addDetailsFragment()
        }
        setRecyclerView()
    }

    private fun addDetailsFragment(){
        val fragmentManager = fragmentManager
        val fragmentTransaction = fragmentManager?.beginTransaction()
        fragmentTransaction?.replace(R.id.fragmentContainerView, AddEmployeeFragment())
        fragmentTransaction?.addToBackStack(null)
        fragmentTransaction?.commit()
    }
    private fun setUpList(){
        val model = ViewModelProvider(this).get(EmployeeViewModel(activity!!.application)::class.java)
        model.getAllDetails().observe(viewLifecycleOwner, Observer {
            myAdapter = EmployeeAdopter(it as ArrayList<EmployeeData>)
            recyclerview.adapter = myAdapter
        })
    }
    private fun setRecyclerView(){
        val linearLayoutManager = LinearLayoutManager(context,RecyclerView.VERTICAL,false)
        recyclerview.layoutManager = linearLayoutManager
        setUpList()
    }

}