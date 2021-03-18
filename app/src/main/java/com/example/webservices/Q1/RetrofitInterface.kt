package com.example.webservices.Q1

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitInterface {

    @GET("posts")
    fun getData(@Query("id")id:Int):Call<List<ModelData>>
}