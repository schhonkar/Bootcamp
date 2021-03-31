package com.example.jetpack.Q1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpack.Q1.Adapter.EmployeeAdopter
import com.example.jetpack.Q1.Fragment.AddEmployeeFragment
import com.example.jetpack.Q1.Fragment.DisplayDataFragment
import com.example.jetpack.Q1.VewModel.EmployeeViewModel
import com.example.jetpack.R
import kotlinx.android.synthetic.main.activity_room_main.*
import java.util.concurrent.Executors

class RoomMainActivity : AppCompatActivity() {
//    lateinit var fragment:Fragment
//    lateinit var model: EmployeeViewModel
//    lateinit var myAdapter: EmployeeAdopter
//    lateinit var recyclerView:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_main)


            addFragmentView()
//            fragment = AddEmployeeFragment()


//        floatingButton.setOnClickListener {
//            var fragmentManager = supportFragmentManager
//            val fragmentTransaction = fragmentManager.beginTransaction()
//
//            fragmentTransaction.add(R.id.fragmentView, fragment, "fragment added")
//            fragmentTransaction.addToBackStack("added").commit()
//
//            fragmentView.visibility= View.VISIBLE
//            recyclerview.visibility = View.INVISIBLE
//        }
//        setrecyclerView()
//        setModel()
    }

//    private fun setrecyclerView(){
//        recyclerView = findViewById(R.id.recyclerview)
//        recyclerView.apply {
//            layoutManager = LinearLayoutManager(this@RoomMainActivity)
//            myAdapter = EmployeeAdopter(this@RoomMainActivity)
//            adapter = myAdapter
//        }
//    }
//    fun setModel(){
//        Executors.newSingleThreadExecutor().execute {
//            model= ViewModelProviders.of(this).get(EmployeeViewModel(application)::class.java)
//            runOnUiThread {
//                model.getAllEmpObserver().observe(this, Observer {
//                    fragmentView.visibility= View.INVISIBLE
//                    recyclerView.visibility=View.VISIBLE
//                    myAdapter.setData(ArrayList(it))
//                })



//            }

//        }
//    }

    private fun addFragmentView(){
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.add(R.id.fragmentContainerView,DisplayDataFragment())
        transaction.commit()
    }

}