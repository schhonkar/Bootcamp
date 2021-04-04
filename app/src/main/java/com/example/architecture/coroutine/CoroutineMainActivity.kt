package com.example.architecture.coroutine

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.architecture.R
import kotlinx.android.synthetic.main.activity_coroutine_main.*
import kotlinx.coroutines.launch
import retrofit2.Response

class CoroutineMainActivity : AppCompatActivity() {

    private lateinit var adapter: MyAdapter
    lateinit var progressDialog: ProgressDialog
    var data = ArrayList<Model>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine_main)

        createProgressDialog()
        progressDialog.show()
        setRecyclerView()
        getData()
    }

    private fun setRecyclerView(){
        val linearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerView.layoutManager = linearLayoutManager

        adapter = MyAdapter(this,data)
        recyclerView.adapter = adapter
    }
    private fun createProgressDialog() {
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Loading")
        progressDialog.setMessage("Please wait to get the data..")
        progressDialog.setCancelable(false)
    }

    private fun getData(){
        lifecycleScope.launch {
            val call = ApiClint.getClient.getData()
            call.enqueue(object : retrofit2.Callback<List<Model>> {
                override fun onFailure(call: retrofit2.Call<List<Model>>, t: Throwable) {
                    Toast.makeText(this@CoroutineMainActivity, "There is some error", Toast.LENGTH_SHORT).show()
                    progressDialog.dismiss()
                }

                override fun onResponse(
                    call: retrofit2.Call<List<Model>>,
                    response: Response<List<Model>>
                ) {
                    progressDialog.dismiss()
                    data.addAll(response.body()?: ArrayList())
                    recyclerView.adapter!!.notifyDataSetChanged()
                }
            })
        }
    }

}