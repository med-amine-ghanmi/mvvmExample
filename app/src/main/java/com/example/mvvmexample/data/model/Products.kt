package com.example.mvvmexample.data.model


import com.google.gson.annotations.SerializedName

data class Products(
    @SerializedName("products")
    val products: List<Product>?
)