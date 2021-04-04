package com.example.architecture.coroutine

import android.content.Context
import android.view.Display
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.architecture.R
import kotlinx.android.synthetic.main.item_view.view.*

class MyAdapter(private val context: Context,private val data:List<Model>):RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val titleView = view.findViewById<TextView>(R.id.titleView)
        val msgBody = view.findViewById<TextView>(R.id.msgView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titleView.text = data[position].title
        holder.msgBody.text = data[position].body
    }

    override fun getItemCount(): Int {
        return data.size
    }
}