package com.example.architecture.coroutine
import com.google.gson.annotations.SerializedName


data class Model(
    @SerializedName("id")
    val ID: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("body")
    val body: String
)
