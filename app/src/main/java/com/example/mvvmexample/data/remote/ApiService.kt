package com.example.mvvmexample.data.remote

import com.example.mvvmexample.data.model.Products
import com.example.mvvmexample.utils.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("products?display=full&ws_key=$API_KEY&output_format=JSON&limit=10")
    suspend fun getProducts(): Response<Products>

}