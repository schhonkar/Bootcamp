package com.example.storageapp

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_sql_lite.*
import kotlinx.android.synthetic.main.updatedialog.*
import java.util.concurrent.Executors


class RoomDataBase : AppCompatActivity(),RoomRecyclerAdapter.OnItemClickListner{
    var itemadapter:RoomRecyclerAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sql_lite)
        addbutton.setOnClickListener {
            addData()
        }

          setRoomRecyclerView()
    }

    private fun addData() {
         var database = RoomDatabaseBuilder().getInstance(this)
        val rname = nameTextView.text.toString()
        val rnumber = numberTextView.text.toString()
        val raddress = addressTextView.text.toString()
        if (rname.isNotEmpty() && rnumber.isNotEmpty() && raddress.isNotEmpty()) {

                Executors.newSingleThreadExecutor().execute {
                    database.empDao().insertPerson(EmployeeDatabase(0, name = rname, address = raddress, number = rnumber))
                }
            Toast.makeText(applicationContext, "Data saved", Toast.LENGTH_SHORT).show()
            nameTextView.setText("")
            numberTextView.setText("")
            addressTextView.setText("")
        } else {
            Toast.makeText(applicationContext, "Please fill all the fields", Toast.LENGTH_SHORT).show()
        }

    }


    private fun setRoomRecyclerView() {
        var list: List<EmployeeDatabase> = ArrayList<EmployeeDatabase>()
        var database = RoomDatabaseBuilder().getInstance(this)

        Executors.newSingleThreadExecutor().execute {
            list = database.empDao().getAllPerson()
            if (list.size > 0) {
                rvItemsList.apply {
                    runOnUiThread() {
                        rvItemsList.visibility = View.VISIBLE
                        rvItemsList.layoutManager = LinearLayoutManager(this@RoomDataBase, RecyclerView.VERTICAL, false)
                        itemadapter = RoomRecyclerAdapter(this@RoomDataBase,list as ArrayList<EmployeeDatabase>)
                        rvItemsList.adapter = itemadapter
                        itemadapter!!.notifyDataSetChanged()
                    }
                }


            }
        }

    }
    override fun onClickUpdate(position: Int, name: String, address: String, number: String) {
        val updateDialog = Dialog(this,R.style.Theme_Dialog)
        updateDialog.setCancelable(false)
        updateDialog.setContentView(R.layout.updatedialog)
        updateDialog.etUpdateName.setText(name)
        updateDialog.etUpdateNumber.setText(number)
        updateDialog.etUpdateAddress.setText(address)
        val database = RoomDatabaseBuilder().getInstance(this)
        updateDialog.tvUpdate.setOnClickListener(View.OnClickListener {
            val name = updateDialog.etUpdateName.text.toString()
            val number = updateDialog.etUpdateNumber.text.toString()
            val address = updateDialog.etUpdateAddress.text.toString()

            val database = RoomDatabaseBuilder().getInstance(this)
            if (name.isNotEmpty() && number.isNotEmpty() && address.isNotEmpty()) {
                Executors.newSingleThreadExecutor().execute{
                    database.empDao().updatePerson(EmployeeDatabase(position,name,address,number))
                }
                setRoomRecyclerView()
                updateDialog.dismiss()

            }
            else{
                Toast.makeText(applicationContext,"Fields can't be blanck",Toast.LENGTH_SHORT).show()
            }
        })
        updateDialog.tvCancel.setOnClickListener {
            updateDialog.dismiss()
        }
        updateDialog.show()
    }


    override fun onClickDelete(position: Int) {
        val database = RoomDatabaseBuilder().getInstance(this)
        Executors.newSingleThreadExecutor().execute{
            database.empDao().deletePerson(EmployeeDatabase(id=position))
        }
        setRoomRecyclerView()
        Log.e("RoomDataBase","Delete clicked")
    }

}








