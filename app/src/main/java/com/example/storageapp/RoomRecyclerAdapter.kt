package com.example.storageapp

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.room.RoomDatabase
import kotlinx.android.synthetic.main.updatedialog.*
import java.util.concurrent.Executors

class RoomRecyclerAdapter(val context:Context,val list:ArrayList<EmployeeDatabase>):
    RecyclerView.Adapter<RoomRecyclerAdapter.RoomViewHolder>() {

    private var mylistner:OnItemClickListner? = null
    var myArrayList:List<EmployeeDatabase>? = null



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder {
       return RoomViewHolder(
           LayoutInflater.from(context).inflate(
               R.layout.itemview,parent,false
            )
       )
    }

    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {
        val items = list.get(position)
        holder.name.text = items.name
        holder.number.text = items.number
        holder.address.text = items.address
        holder.update.setOnClickListener {
//            mylistner?.onClickUpdate(position,holder.name.text.toString(),holder.number.text.toString(),holder.address.text.toString())
            Log.e("BindView","update clicked")
            update(position,holder.name.text.toString(),holder.address.text.toString(),holder.number.text.toString(),items.id)
        }
        holder.delete.setOnClickListener {
//            mylistner?.onClickDelete(items.id)
            delete(items.id,position,holder.name.text.toString())
            Log.e("BindView","Delete clicked ${items.id}")
//            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class RoomViewHolder(view: View):RecyclerView.ViewHolder(view){
        val name = view.findViewById<TextView>(R.id.rnameTextView)
        val number = view.findViewById<TextView>(R.id.rnumberTextView)
        val address = view.findViewById<TextView>(R.id.raddressTextView)
        val update = view.findViewById<Button>(R.id.updatebutton)
        val delete = view.findViewById<Button>(R.id.deletebutton)
    }

    fun setTasks(employeeList: List<EmployeeDatabase>) {
        myArrayList = employeeList
        notifyDataSetChanged()
    }

    fun deleteTasks(position: Int, employeeList: List<EmployeeDatabase>) {
        myArrayList = employeeList
        notifyDataSetChanged()
    }

    fun updateTasks(position : Int, employeeList: List<EmployeeDatabase>){
        myArrayList = employeeList
        notifyItemChanged(position)
        notifyDataSetChanged()
    }

    fun setListner(listner:OnItemClickListner){
         mylistner = listner
    }

    interface OnItemClickListner{
        fun onClickDelete(position:Int)
        fun onClickUpdate(position: Int,name:String,address:String,number:String)
    }

    fun delete(id:Int,position:Int,name: String){

        val builder = AlertDialog.Builder(context)
        builder.setTitle("Delete Record")
        builder.setMessage("are you sure you want to delete $name.")
        builder.setIcon(android.R.drawable.ic_dialog_alert)
        builder.setPositiveButton("Yes"){ dialogInterface: DialogInterface, which ->
            val database = RoomDatabaseBuilder().getInstance(context)
            Executors.newSingleThreadExecutor().execute{
                database.empDao().deletePerson(EmployeeDatabase(id=id))
            }
            Toast.makeText(context,"Deleted successfully",Toast.LENGTH_SHORT).show()
            deleteItem(position)
            dialogInterface.dismiss()

        }
        builder.setNegativeButton("No"){ dialogInterface: DialogInterface, which ->
            dialogInterface.dismiss()

        }
        val alerDialog = builder.create()
        alerDialog.setCancelable(false)
        alerDialog.show()

    }
    private fun deleteItem(position: Int) {
        list.removeAt(position)
        notifyDataSetChanged()
    }

    private  fun update(position: Int, name: String, address: String, number: String,id:Int){
        val updateDialog = Dialog(context,R.style.Theme_Dialog)
        updateDialog.setCancelable(false)
        updateDialog.setContentView(R.layout.updatedialog)
        updateDialog.etUpdateName.setText(name)
        updateDialog.etUpdateNumber.setText(number)
        updateDialog.etUpdateAddress.setText(address)
        val database = RoomDatabaseBuilder().getInstance(context)
        updateDialog.tvUpdate.setOnClickListener(View.OnClickListener {
            val name = updateDialog.etUpdateName.text.toString()
            val number = updateDialog.etUpdateNumber.text.toString()
            val address = updateDialog.etUpdateAddress.text.toString()
            var list1:List<EmployeeDatabase>? = null
            val database = RoomDatabaseBuilder().getInstance(context)
            if (name.isNotEmpty() && number.isNotEmpty() && address.isNotEmpty()) {
                Executors.newSingleThreadExecutor().execute{
                    database.empDao().updatePerson(EmployeeDatabase(id = id,name=name,address=address,number=number))
                    list1 = database.empDao().getAllPerson()
                }
                Toast.makeText(context,"Updated successfully",Toast.LENGTH_SHORT).show()
                notifyDataSetChanged()
                list1?.let { it1 -> updateTasks(position, it1) }
                updateDialog.dismiss()

            }
            else{
                Toast.makeText(context,"Fields can't be blanck",Toast.LENGTH_SHORT).show()
            }
        })
        updateDialog.tvCancel.setOnClickListener {
            updateDialog.dismiss()
        }
        updateDialog.show()
    }

}