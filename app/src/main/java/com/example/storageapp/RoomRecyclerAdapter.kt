package com.example.storageapp

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.room.RoomDatabase

class RoomRecyclerAdapter(val context:Context,val list:ArrayList<EmployeeDatabase>):
    RecyclerView.Adapter<RoomRecyclerAdapter.RoomViewHolder>() {

    private var mylistner:OnItemClickListner? = null



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder {
       return RoomViewHolder(
           LayoutInflater.from(context).inflate(
               R.layout.itemview,parent,false
            )
       )
    }

    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {
        val items = list.get(position)
        holder.name.text = items.name
        holder.number.text = items.number
        holder.address.text = items.address
        holder.update.setOnClickListener {
            mylistner?.onClickUpdate(position,holder.name.text.toString(),holder.number.text.toString(),holder.address.text.toString())
            Log.e("BindView","update clicked")
        }
        holder.delete.setOnClickListener {
            mylistner?.onClickDelete(items.id)
            Log.e("BindView","Delete clicked ${items.id}")
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class RoomViewHolder(view: View):RecyclerView.ViewHolder(view){
        val name = view.findViewById<TextView>(R.id.rnameTextView)
        val number = view.findViewById<TextView>(R.id.rnumberTextView)
        val address = view.findViewById<TextView>(R.id.raddressTextView)
        val update = view.findViewById<Button>(R.id.updatebutton)
        val delete = view.findViewById<Button>(R.id.deletebutton)
    }

    fun setListner(listner:OnItemClickListner){
         mylistner = listner
    }

    interface OnItemClickListner{
        fun onClickDelete(position:Int)
        fun onClickUpdate(position: Int,name:String,address:String,number:String)
    }

}