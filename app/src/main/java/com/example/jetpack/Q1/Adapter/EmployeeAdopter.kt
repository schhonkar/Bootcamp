package com.example.jetpack.Q1.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpack.Q1.Database.EmployeeData
import com.example.jetpack.R

class EmployeeAdopter(private var data: ArrayList<EmployeeData>):RecyclerView.Adapter<EmployeeAdopter.viewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        return viewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_item_view,parent,false))
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val currentItem = data[position]
        holder.nameView.text = currentItem.name
        holder.emailView.text = currentItem.email
        holder.numberView.text = currentItem.number
    }

    override fun getItemCount(): Int {
        return data.size
    }


    class viewHolder(view: View):RecyclerView.ViewHolder(view){
            val nameView = view.findViewById<TextView>(R.id.rvNameView)
            val emailView = view.findViewById<TextView>(R.id.rvEmailView)
            val numberView = view.findViewById<TextView>(R.id.rvNumberView)
    }

}