package com.example.assesments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Paging : AppCompatActivity() {
    private val listViewType2 = mutableListOf<Int>()

    private var startPage = 1
    private var isLoading = false
    private val limit = 4

    private var progressBar : ProgressBar? = null

    private lateinit var recyclerView2: RecyclerView
    private lateinit var multiViewRecyclerAdapter: MultiViewRecyclerAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paging)

        progressBar = findViewById<ProgressBar>(R.id.progressBar)


        recyclerView2 = findViewById(R.id.recyclerView)

        layoutManager = LinearLayoutManager(applicationContext)
        recyclerView2.layoutManager = layoutManager

        multiViewRecyclerAdapter = MultiViewRecyclerAdapter(this, listViewType2)
        recyclerView2.adapter = multiViewRecyclerAdapter

        //getPage()
        getPage()
        //checkForPagination()
        Handler().post({checkForPagination()})

        recyclerView2.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView2: RecyclerView, dx: Int, dy: Int) {

                // dy means vertical scroll position
                if (dy > 0) {
                    checkForPagination()
                }
                super.onScrolled(recyclerView2, dx, dy)
            }
        })
    }

    private fun getPage() {


        addDataInList()

        progressBar!!.visibility = View.GONE

        multiViewRecyclerAdapter.notifyDataSetChanged()
        isLoading = false


    }
    private fun checkForPagination(){
        val visibleItemCount = layoutManager.childCount
        val totalItemCount = layoutManager.itemCount
        val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()

        // use isLastPage to stop when last page shown
        // to the users
        if (!isLoading) {
            if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount) {
                startPage++
                progressBar!!.visibility = View.VISIBLE
                isLoading = true
                Handler().postDelayed({getPage()}, 2000)
            }
        }
    }


    private fun addDataInList(){
        val start = (startPage - 1) * limit
        val end = (startPage) * limit
        //val start = 1
        //val end = 5

        for (i in start..end) {
            when {
                i % 2 == 0 -> {
                    listViewType2.add(MultiViewRecyclerAdapter.TEXT_VIEW)
                }
                i % 3 == 0 -> {
                    listViewType2.add(MultiViewRecyclerAdapter.IMAGE_VIEW)
                }
                else -> {
                    listViewType2.add(MultiViewRecyclerAdapter.TEXT_WITH_IMAGE_VIEW)
                }
            }
        }
    }
}