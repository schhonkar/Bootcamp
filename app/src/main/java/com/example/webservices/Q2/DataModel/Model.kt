package com.example.webservices.Q2.DataModel

import com.google.gson.annotations.SerializedName

data class Model(

    val name: String,
    val message: String,
    @SerializedName("profileImage")
    val profileImgURL: String
)
