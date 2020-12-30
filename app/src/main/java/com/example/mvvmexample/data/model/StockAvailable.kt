package com.example.mvvmexample.data.model


import com.google.gson.annotations.SerializedName

data class StockAvailable(
    @SerializedName("id")
    val id: String?,
    @SerializedName("id_product_attribute")
    val idProductAttribute: String?,
    @SerializedName("quantity")
    val quantity: String?
)