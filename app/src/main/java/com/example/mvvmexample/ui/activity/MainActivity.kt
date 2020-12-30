package com.example.mvvmexample.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.mvvmexample.R
import com.example.mvvmexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {



    private val navHostFragment: NavHostFragment by lazy { supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment }
    private val navController: NavController by lazy { navHostFragment.navController }

    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(viewBinding.root)

        initViews()
        initEvents()

    }

    private fun initViews(){

        viewBinding.bottomNavigation.setupWithNavController(navController)
        NavigationUI.setupWithNavController(viewBinding.bottomNavigation, navController)

    }

    private fun initEvents(){
        viewBinding.bottomNavigation.setOnNavigationItemSelectedListener { item ->

                navController.navigate(item.itemId)
            true
        }
    }


}