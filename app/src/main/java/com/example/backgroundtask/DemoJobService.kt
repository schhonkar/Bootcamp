package com.example.backgroundtask

import android.app.job.JobParameters
import android.app.job.JobService
import android.util.Log
import java.util.concurrent.Executors

class DemoJobService:JobService() {
    private var jobCancelled = false
    val Tag = "Demo JobService"
    override fun onStartJob(params: JobParameters?): Boolean {
       Log.e(Tag,"Job Started")
        doBackgroundJob(params)
        return true
    }
    private fun doBackgroundJob(params:JobParameters?){
        Thread(Runnable {
            kotlin.run {
                for (i in 0..10) {
                    if (jobCancelled) {
                        return@Runnable
                    }
                    Log.e(Tag, "run: "+i)
                    try {
                        Thread.sleep(1000)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }
                Log.e(Tag, "Job finished")
                jobFinished(params, false)
            }
        }).start()


    }

    override fun onStopJob(params: JobParameters?): Boolean {
        Log.e(Tag,"Job Cancelled")
        jobCancelled = true
        return true

    }
}