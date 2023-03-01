package com.example.forecast_diploma.presentation

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.forecast_diploma.databinding.FragmentMainWeatherBinding
import com.example.forecast_diploma.di.model.WeatherModel
import com.squareup.picasso.Picasso


import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainWeatherFragment : Fragment() {


    private var _binding: FragmentMainWeatherBinding? = null
    private val binding: FragmentMainWeatherBinding get() = _binding!!
    private val viewModel: MainWeatherViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainWeatherBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getCurrentData()

        viewModel.currentWeather.observe(viewLifecycleOwner) {
            it?.let { weather ->
                binding.tvCity.text = weather.name
                binding.tvCondition.text = weather.text
                binding.tvlocalTime.text = weather.localtime
                binding.tvTemperature.text = weather.temp_c.toString()

                Picasso.get().load("https:" + weather.icon).into(binding.imageWeather)
            }
        }
    }
}
