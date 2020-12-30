package com.example.mvvmexample.ui.first

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mvvmexample.R
import com.example.mvvmexample.data.model.Product
import com.example.mvvmexample.data.remote.ApiService
import com.example.mvvmexample.data.remote.RetrofitClient
import com.example.mvvmexample.data.repository.Repository
import com.example.mvvmexample.databinding.FragmentFirstBinding
import com.example.mvvmexample.ui.first.adapter.ProductAdapter


class FirstFragment : Fragment() {


    private lateinit var viewBinding: FragmentFirstBinding

    private var retrofitClient = RetrofitClient
    private var repository = Repository(retrofitClient)

    private val productsAdapter by lazy { ProductAdapter(ArrayList()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        viewBinding = DataBindingUtil.inflate(
            LayoutInflater.from(requireContext()),
            R.layout.fragment_first,
            container,
            false
        )
        return viewBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        initViewModel()

    }

    private fun initViews() {

        viewBinding.productsRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(this.context, 2)
        }

    }

    private fun initViewModel(){
        val viewModelFactory = FirstFragmentViewModelFactory(repository)
        val viewModel =
            ViewModelProvider(this, viewModelFactory).get(FirstFragmentViewModel::class.java)

        viewModel.getProducts()
        viewModel.productsLiveData.observe(viewLifecycleOwner, Observer {

            viewBinding.productsRecyclerView.adapter = ProductAdapter(it)

        })
    }

    private fun initEvents() {


    }


}