package com.example.mvvmexample.ui.first

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmexample.data.model.Product
import com.example.mvvmexample.data.model.Products
import com.example.mvvmexample.data.remote.ApiService
import com.example.mvvmexample.data.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class FirstFragmentViewModel @ViewModelInject constructor(
    private val repository: Repository
) : ViewModel() {

    private  val _productsLiveData = MutableLiveData<ArrayList<Product>>()
    val productsLiveData: LiveData<ArrayList<Product>> = _productsLiveData

    fun getProducts(){

        viewModelScope.launch {
            repository.getProducts.flowOn(Dispatchers.IO).collect {

                _productsLiveData.postValue(it.products as ArrayList<Product>)

            }
        }

    }



}