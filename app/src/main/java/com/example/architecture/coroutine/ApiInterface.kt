package com.example.architecture.coroutine

import retrofit2.http.GET

interface ApiInterface {

    @GET("posts")
    fun getData(): retrofit2.Call<List<Model>>
}