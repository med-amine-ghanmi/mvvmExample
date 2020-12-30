package com.example.mvvmexample.data.repository

import com.example.mvvmexample.data.model.Products
import com.example.mvvmexample.data.remote.ApiService
import com.example.mvvmexample.data.remote.RetrofitClient
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.Dispatcher
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

class Repository constructor(private val retrofitClient: RetrofitClient)   {


        val getProducts : Flow<Products> = flow {
            val response = retrofitClient.getRetrofitClient().getProducts()
            if(response.isSuccessful){
                response.body()?.let {
                    emit(it)
                } ?: kotlin.run {
                    emit(Products(ArrayList()))
                }
            }
            else {
                emit(Products(ArrayList()))
            }
        }.flowOn(Dispatchers.IO)


}