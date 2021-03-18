package com.example.webservices.Q2.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.webservices.Q2.DataModel.Model
import com.example.webservices.R

class MyAdapter(val context:Context,val list:List<Model>): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    class MyViewHolder(view:View):RecyclerView.ViewHolder(view){
        val imageView = view.findViewById<ImageView>(R.id.rvImageView)
        val nameView = view.findViewById<TextView>(R.id.rvTextviewname)
        val messageView = view.findViewById<TextView>(R.id.rvTextviewmessage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.nameView.text = list[position].name
        holder.messageView.text = list[position].message
        val imageUrl = list[position].profileImgURL
        Glide.with(context).load(imageUrl).placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.imageView)

    }

    override fun getItemCount(): Int {
        return list.size
    }
}