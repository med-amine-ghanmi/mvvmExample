package com.example.mvvmexample.data.model


import com.google.gson.annotations.SerializedName

data class Associations(
    @SerializedName("categories")
    val categories: List<Category>?,
    @SerializedName("images")
    val images: List<Image>?,
    @SerializedName("stock_availables")
    val stockAvailables: List<StockAvailable>?
)