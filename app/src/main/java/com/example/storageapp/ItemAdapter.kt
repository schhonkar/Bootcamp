package com.example.storageapp

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(val context:Context,val list:ArrayList<Model>):
    RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.itemview,parent,false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val items = list.get(position)
        holder.name.text = items.name
        holder.number.text = items.number
        holder.address.text = items.address
        holder.update.setOnClickListener {
            if (context is SqlLite){
                context.updateRecord(items)
            }
        }
        holder.delete.setOnClickListener {
            if (context is SqlLite){
                context.deleteRecord(items)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
    class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        val name = view.findViewById<TextView>(R.id.rnameTextView)
        val number = view.findViewById<TextView>(R.id.rnumberTextView)
        val address = view.findViewById<TextView>(R.id.raddressTextView)
        val update = view.findViewById<Button>(R.id.updatebutton)
        val delete = view.findViewById<Button>(R.id.deletebutton)
    }
}