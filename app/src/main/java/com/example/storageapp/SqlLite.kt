package com.example.storageapp

import android.Manifest
import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_sql_lite.*
import kotlinx.android.synthetic.main.updatedialog.*

class SqlLite : AppCompatActivity() {
    val PERMISSIONS_REQUEST_READ_CONTACTS = 101
    val contactHashMap = HashMap<String, String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sql_lite)
        addbutton.setOnClickListener {
            addRecord()
            setRecyclerView()
        }
        setRecyclerView()
        loadContent.setOnClickListener {
            loadContacts()
            setRecyclerView()
        }
    }

    private fun addRecord(){
        val name = nameTextView.text.toString()
        val number = numberTextView.text.toString()
        val address = addressTextView.text.toString()
        val databaseHandler:DataBaseHandler =   DataBaseHandler(this)
        if(name.isNotEmpty() && address.isNotEmpty() && number.isNotEmpty()){
            val status = databaseHandler.addEmployee(Model(0,name, address, number))
            if (status > -1){
                Toast.makeText(applicationContext,"Data Saved",Toast.LENGTH_SHORT).show()
                nameTextView.setText("")
                addressTextView.setText("")
                numberTextView.setText("")
            }
        }
        else{
            Toast.makeText(applicationContext,"Please insert in all the fields",Toast.LENGTH_SHORT).show()
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
                val status = databasehandler.updateEmployee(Model(emp.id,name, number, address))
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

            val status = databasehandler.deleteEmployee(Model(emp.id,"", "", ""))

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
    private fun loadContacts() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(
                Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(arrayOf(Manifest.permission.READ_CONTACTS),
                PERMISSIONS_REQUEST_READ_CONTACTS)
            //callback onRequestPermissionsResult
        } else {
            val contactHM = getContacts()
            if (contactHM.size > 0) {
                for (contact in contactHM) {
                    insertDataInSQLite(contact.key, contact.value)
                }
                Toast.makeText(this, "${contactHM.size} contact has been added successfully", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray)
    {
        if (requestCode == PERMISSIONS_REQUEST_READ_CONTACTS) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                loadContacts()
            } else {
                Toast.makeText(this, "Allow the permission from settings", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun getContacts(): HashMap<String, String> {
        val resolver = contentResolver
        val cursor =
            resolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null)
        if (cursor!!.count > 0) {
            while (cursor.moveToNext()) {
                val id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID))
                val name =
                    cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
                val phoneNumber =
                    cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))
                        .toInt()

                if (phoneNumber > 0) {
                    val cursorPhone = contentResolver.query(
                        ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                        null,
                        ContactsContract.CommonDataKinds.Phone._ID + "=?",
                        arrayOf(id),
                        null
                    )

                    if (cursorPhone!!.count > 0) {
                        while (cursorPhone.moveToNext()) {
                            val phoneNumValue = cursorPhone.getString(
                                cursorPhone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
                            //Log.i(TAG, "Contact: $name, $phoneNumValue")
                            contactHashMap[phoneNumValue] = name
                        }
                    }
                    cursorPhone.close()
                }
            }
        }
        else {
            Toast.makeText(this, "No contacts available", Toast.LENGTH_SHORT).show()
        }
        cursor.close()
        return contactHashMap
    }
    private fun insertDataInSQLite(key: String, value: String) {

        val databaseManager = DataBaseHandler(this)


        databaseManager.addEmployee(
            Model(
//                id = 0,
                name = value,
                number = key,
                address = "UP"
            )
        )
    }


}