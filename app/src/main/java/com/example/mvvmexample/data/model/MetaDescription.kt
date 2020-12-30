package com.example.mvvmexample.data.model


import com.google.gson.annotations.SerializedName

data class MetaDescription(
    @SerializedName("id")
    val id: String?,
    @SerializedName("value")
    val value: String?
)