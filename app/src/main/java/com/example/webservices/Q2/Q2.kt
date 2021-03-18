package com.example.webservices.Q2

import android.app.ProgressDialog
import android.graphics.ColorSpace
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.webservices.Q2.Adapter.MyAdapter
import com.example.webservices.Q2.DataModel.Model
import com.example.webservices.Q2.DataModel.ResponseModel
import com.example.webservices.Q2.Retrofit.ApiClint
import com.example.webservices.R
import kotlinx.android.synthetic.main.activity_q2.*
import retrofit2.Response

class Q2 : AppCompatActivity() {
    var list = ArrayList<Model>()
    lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_q2)
        createProgressDialog()
        setRecyclerView()
//        getPostsData()
//        progressDialog.show()
        bloadData.setOnClickListener {
            setRecyclerView()
            getPostsData()
            progressDialog.show()
        }

    }
    private fun createProgressDialog() {
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Loading")
        progressDialog.setMessage("Please wait..")
        progressDialog.setCancelable(false)
    }
    private fun setRecyclerView(){
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerVIew.layoutManager = linearLayoutManager
        var customAdapter = MyAdapter(this, list)
        recyclerVIew.adapter = customAdapter
    }
    private fun getPostsData() {
        progressDialog.show()

        val call = ApiClint.getClient.getPosts()
        call.enqueue(object : retrofit2.Callback<ResponseModel>{


            override fun onResponse(
                call: retrofit2.Call<ResponseModel>,
                response: Response<ResponseModel>
            ) {
                list.addAll(response.body()?.posts?: ArrayList())
                recyclerVIew.adapter!!.notifyDataSetChanged()
                progressDialog.dismiss()

            }

            override fun onFailure(call: retrofit2.Call<ResponseModel>, t: Throwable) {

                Toast.makeText(this@Q2, "There is some error while getting post", Toast.LENGTH_SHORT).show()
                progressDialog.dismiss()
            }

        })
    }
}