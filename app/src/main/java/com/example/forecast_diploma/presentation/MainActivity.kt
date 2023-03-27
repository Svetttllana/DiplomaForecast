package com.example.forecast_diploma.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.widget.Switch
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.forecast_diploma.R
import com.example.forecast_diploma.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(
            R.id.fragmentContainerView
        ) as NavHostFragment

        navController = navHostFragment.navController
        binding.bottomNavigation.setupWithNavController(navController)

        viewModel.networkAccess()
        viewModel.network.observe(this) { access ->
            if (access) {
                Toast.makeText(
                    applicationContext,
                    getString(R.string.connected),
                    Toast.LENGTH_SHORT
                ).show()
            } else
                Toast.makeText(
                    applicationContext,
                    getString(R.string.noConnected),
                    Toast.LENGTH_LONG
                ).show()
        }

    }

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.teme_switch, menu)
        val menuM = menu?.findItem(R.id.action_switch)
        menuM?.let {
            val switch = it.actionView?.findViewById<Switch>(R.id.action_switch)
            if (switch != null) {
                switch.isChecked = viewModel.darkTeme.value ?: false
            }
            switch?.setOnCheckedChangeListener { _, _ ->
                val isCheckd = false
                viewModel.checkTeme(isCheckd)
                viewModel.saveDarkTem()
            }
            viewModel.darkTeme.observe(this) { isChecked ->

                if (isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                }

            }
        }
        return true
    }

}
