package com.example.jetpack.q1.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpack.q1.EmployeeData
import com.example.jetpack.R
import com.example.jetpack.databinding.RecyclerItemViewBinding

class EmployeeAdopter(private var data: ArrayList<EmployeeData>):RecyclerView.Adapter<EmployeeAdopter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        return viewHolder(LayoutInflater.from(parent.context)
//                .inflate(R.layout.recycler_item_view,parent,false))
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<RecyclerItemViewBinding>(inflater, R.layout.recycler_item_view, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val currentItem = data[position]
//        holder.nameView.text = currentItem.name
//        holder.emailView.text = currentItem.email
//        holder.numberView.text = currentItem.number
        holder.binding.employee = data[position]
    }

    override fun getItemCount(): Int {
        return data.size
    }


    class ViewHolder(val binding: RecyclerItemViewBinding):RecyclerView.ViewHolder(binding.root){
//            val nameView = view.findViewById<TextView>(R.id.rvNameView)
//            val emailView = view.findViewById<TextView>(R.id.rvEmailView)
//            val numberView = view.findViewById<TextView>(R.id.rvNumberView)
    }

}