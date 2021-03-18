package com.example.webservices.Q2.Retrofit

import com.example.webservices.Q2.DataModel.Model
import com.example.webservices.Q2.DataModel.ResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {

    @GET("v2/posts.json")
    fun getPosts(): Call<ResponseModel>
}