package com.example.architecture.coroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch



    fun main(){
        GlobalScope.launch {
            fibonacciSeries(10)
        }
        Thread.sleep(10000)
    }


suspend fun fibonacciSeries(range:Int){
        var a = 0
        var b = 1
        var temp = 0
        println("Fibonacci series is:")
        for(i in 1..range){
            print("$a ")
            temp = a+b
            a = b
            b = temp
            delay(300)
        }
    }


