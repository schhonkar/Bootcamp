package com.example.assesments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LayoutPart1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout_part1)
        val list = ArrayList<Data>()
        list.add(Data(R.drawable.img2,"Ice Cream Sundae","147, Delhi",4,"576 views","11 Mar 2021 11:10PM","Rs. 150"))
        list.add(Data(R.drawable.img2,"Ice Cream Sundae","147, Delhi",4,"576 views","11 Mar 2021 11:10PM","Rs. 100"))
        list.add(Data(R.drawable.img2,"Ice Cream Sundae","147, Delhi",4,"576 views","11 Mar 2021 11:10PM","Rs. 125"))
        list.add(Data(R.drawable.img2,"Ice Cream Sundae","147, Delhi",4,"576 views","11 Mar 2021 11:10PM","Rs. 126"))
        list.add(Data(R.drawable.img2,"Ice Cream Sundae","147, Delhi",4,"576 views","11 Mar 2021 11:10PM","Rs. 250"))
        list.add(Data(R.drawable.img2,"Ice Cream Sundae","147, Delhi",4,"576 views","11 Mar 2021 11:10PM","Rs. 159"))
        list.add(Data(R.drawable.img2,"Ice Cream Sundae","147, Delhi",4,"576 views","11 Mar 2021 11:10PM","Rs. 169"))
        list.add(Data(R.drawable.img2,"Ice Cream Sundae","147, Delhi",4,"576 views","11 Mar 2021 11:10PM","Rs. 160"))
        list.add(Data(R.drawable.img2,"Ice Cream Sundae","147, Delhi",4,"576 views","11 Mar 2021 11:10PM","Rs. 175"))


        val recycleview = findViewById<RecyclerView>(R.id.recitem)
        recycleview.adapter = MyCustomAdapter(list)
        recycleview.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
    }
}