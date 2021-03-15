package com.example.backgroundtask

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var myService: BindService? = null
    var checkBound = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ReceiversQ2.setOnClickListener {
            val intent = Intent(this, Receiver::class.java)
            startActivity(intent)
        }
        q1.setOnClickListener {
            thread()
            Toast.makeText(applicationContext,"Check the Logcat",Toast.LENGTH_SHORT).show()
        }

        musicService()
        bindService()
        bindService.setOnClickListener {
            showDateTime()
        }
        startJob.setOnClickListener {
            scheduleJob()
        }
        cancelJob.setOnClickListener {
            cancelJob()
        }
    }

    private fun thread() {
        val Thread1 = CustomThread1(this)
        val Thread2 = CustomThread2(this)

        Thread2.start()
        Thread1.start()
        Thread2.join()
    }

    private fun musicService() {
        val intent1 = Intent(applicationContext, Music::class.java)
        play.setOnClickListener {
            startService(intent1)
        }
        stop.setOnClickListener {
            stopService(intent1)
        }
    }
    private fun showDateTime() {
        val currentTime = myService?.getCurrentTime()
        Toast.makeText(this, "Date and Time is: ${currentTime.toString()}", Toast.LENGTH_SHORT)
                .show()
    }

    private fun bindService() {
        val intent = Intent(this, BindService::class.java)
        bindService(intent, myConnection, Context.BIND_AUTO_CREATE)
    }

    private val myConnection = object : ServiceConnection {
        override fun onServiceConnected(className: ComponentName, service: IBinder) {
            val binder = service as BindService.MyLocalBinder
            myService = binder.getService()
            checkBound = true
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            checkBound = false
        }
    }
    private fun scheduleJob(){
        val componantName = ComponentName(this,DemoJobService::class.java)
        val info = JobInfo.Builder(101,componantName)
        .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
        .setPersisted(true)
        .setPeriodic(15*60*1000)
        .build()
        val scheduler = getSystemService(Context.JOB_SCHEDULER_SERVICE ) as JobScheduler
        var resultCode = scheduler.schedule(info)
        if (resultCode == JobScheduler.RESULT_SUCCESS){
            Toast.makeText(applicationContext,"Job Started",Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(applicationContext,"Job Failed",Toast.LENGTH_SHORT).show()
        }

    }
    private fun cancelJob(){
        val scheduler = getSystemService(Context.JOB_SCHEDULER_SERVICE ) as JobScheduler
        scheduler.cancel(101)
        Toast.makeText(applicationContext,"Job Cancelled",Toast.LENGTH_SHORT).show()
    }

}