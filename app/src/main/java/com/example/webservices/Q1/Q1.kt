package com.example.webservices.Q1

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.webservices.R
import kotlinx.android.synthetic.main.activity_q1.*
import retrofit2.Call
import retrofit2.Response

class Q1 : AppCompatActivity() {
    lateinit var progressDialog: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_q1)
        createProgressDialog()

        getDetailButton.setOnClickListener {
            val eId = idNumber.text
            if (eId.isEmpty() || eId.toString().toInt() >10 ||  eId.toString().toInt() < 1){

                idNumber.error = "Enter the number in range 1 to 10"
            }
            else{
                progressDialog.show()
                getData(eId.toString().toInt())

            }
        }
    }


    private fun createProgressDialog() {
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Loading")
        progressDialog.setMessage("Please wait..")
        progressDialog.setCancelable(false)
    }
    private fun getData(id:Int){
        val call = RetroFitApi.getClint.getData(id)
        call.enqueue(object : retrofit2.Callback<List<ModelData>>{
            override fun onResponse(
                    call: Call<List<ModelData>>,
                    response: Response<List<ModelData>>
            ) {
                progressDialog.dismiss()
                Log.d("MainActivity", "Data is ${response.body()}")
                for (data in response.body()!!)
                {
                    tvId.text = "ID: ${data.id.toString()}"
                    tvTitle.text = "Title: ${data.title.toString()}"
                    tvBody.text = "Body: ${data.body.toString()}"
                }
            }

            override fun onFailure(call: Call<List<ModelData>>, t: Throwable) {
                Log.i("Q3", "Error is ${t.localizedMessage}")
                Toast.makeText(this@Q1, "There is some error while getting the data", Toast.LENGTH_SHORT).show()
                progressDialog.dismiss()
            }

        })
    }
}