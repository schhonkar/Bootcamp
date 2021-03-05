package com.example.assesments

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyCustomAdapter(val myArrayList:ArrayList<Data>): RecyclerView.Adapter<MyCustomAdapter.MyCustomViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCustomViewHolder {
        return MyCustomViewHolder((LayoutInflater.from(parent.context)
                .inflate(R.layout.itemview,parent,false)))
    }

    override fun onBindViewHolder(holder: MyCustomViewHolder, position: Int) {
        holder.img.setImageResource(myArrayList[position].img)
        holder.name.text = myArrayList[position].iceName
        holder.address.text = myArrayList[position].address
        holder.rating.rating = myArrayList[position].rating.toFloat()
        holder.views.text = myArrayList[position].views
        holder.dateTime.text = myArrayList[position].value
        holder.cost.text = myArrayList[position].cost
    }

    override fun getItemCount(): Int {
        return myArrayList.size
    }

    class  MyCustomViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val img = itemView.findViewById<ImageView>(R.id.imageView)
        val name = itemView.findViewById<TextView>(R.id.textView)
        val address = itemView.findViewById<TextView>(R.id.textView2)
        val rating = itemView.findViewById<RatingBar>(R.id.ratingBar2)
        val views = itemView.findViewById<TextView>(R.id.textView3)
        val dateTime = itemView.findViewById<TextView>(R.id.textView4)
        val cost = itemView.findViewById<TextView>(R.id.textView5)

    }
}