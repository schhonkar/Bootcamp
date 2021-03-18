package com.example.webservices.Q2.DataModel

import com.google.gson.annotations.SerializedName

data class ResponseModel(
    @SerializedName("posts")
    val posts: ArrayList<Model>
)
