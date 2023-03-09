package com.example.forecast_diploma.presentation

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.forecast_diploma.R
import com.example.forecast_diploma.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)


        val navHostFragment=supportFragmentManager.findFragmentById(R.id.fragmentContainerView
        )as NavHostFragment



       navController  = navHostFragment.navController

        binding.bottomNavigation.setupWithNavController(navController)

        val btnav = AppBarConfiguration(
            setOf(R.id.mainWeatherFragment,R.id.searchFragment)
        )

        NavigationUI.setupActionBarWithNavController(this,navController,btnav)
    }




}