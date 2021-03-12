package com.example.storageapp

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_sql_lite.*
import kotlinx.android.synthetic.main.updatedialog.*

class SqlLite : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sql_lite)
        addbutton.setOnClickListener {
            addRecord()
            setRecyclerView()
        }
        setRecyclerView()
    }

    private fun addRecord(){
        val name = nameTextView.text.toString()
        val number = numberTextView.text.toString()
        val address = addressTextView.text.toString()
        val databaseHandler:DataBaseHandler =   DataBaseHandler(this)
        if(name.isNotEmpty() && address.isNotEmpty() && number.isNotEmpty()){
            val status = databaseHandler.addEmployee(Model(0,name,address,number))
            if (status > -1){
                Toast.makeText(applicationContext,"Data Saved",Toast.LENGTH_SHORT).show()
                nameTextView.setText("")
                addressTextView.setText("")
                numberTextView.setText("")
            }
        }
        else{
            Toast.makeText(applicationContext,"Please inser in all the fields",Toast.LENGTH_SHORT).show()
        }
    }
    private fun getItemList():ArrayList<Model>{
        val dataBaseHandler:DataBaseHandler = DataBaseHandler(this)
        val empList:ArrayList<Model> = DataBaseHandler(this).viewEmployee()
        return empList
    }
    private fun setRecyclerView(){
        if (getItemList().size > 0){
                rvItemsList.visibility = View.VISIBLE
                rvItemsList.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
                val itemadapter = ItemAdapter(this,getItemList())
                rvItemsList.adapter = itemadapter

        }

    }
    fun updateRecord(emp:Model){
        val updateDialog = Dialog(this,R.style.Theme_Dialog)
        updateDialog.setCancelable(false)
        updateDialog.setContentView(R.layout.updatedialog)
        updateDialog.etUpdateName.setText(emp.name)
        updateDialog.etUpdateNumber.setText(emp.number)
        updateDialog.etUpdateAddress.setText(emp.address)

        updateDialog.tvUpdate.setOnClickListener(View.OnClickListener {
            val name = updateDialog.etUpdateName.text.toString()
            val number = updateDialog.etUpdateNumber.text.toString()
            val address = updateDialog.etUpdateAddress.text.toString()

            val databasehandler = DataBaseHandler(this)
            if (name.isNotEmpty() && number.isNotEmpty() && address.isNotEmpty()){
                val status = databasehandler.updateEmployee(Model(emp.id,name,number,address))
                if(status > -1){
                    Toast.makeText(applicationContext,"Data updated",Toast.LENGTH_SHORT).show()
                    setRecyclerView()
                    updateDialog.dismiss()
                }
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

    fun deleteRecord(emp: Model){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Delete Record")
        builder.setMessage("are you sure you want to delete ${emp.name}.")
        builder.setIcon(android.R.drawable.ic_dialog_alert)
        builder.setPositiveButton("Yes"){ dialogInterface: DialogInterface, which ->
            val databasehandler = DataBaseHandler(this)

            val status = databasehandler.deleteEmployee(Model(emp.id,"","",""))

            if (status > -1){
                Toast.makeText(applicationContext,"Record Deleted",Toast.LENGTH_SHORT).show()
                setRecyclerView()
            }
            dialogInterface.dismiss()

        }
        builder.setNegativeButton("No"){dialogInterface:DialogInterface,which ->
            dialogInterface.dismiss()

        }
        val alerDialog = builder.create()
        alerDialog.setCancelable(false)
        alerDialog.show()

    }

}