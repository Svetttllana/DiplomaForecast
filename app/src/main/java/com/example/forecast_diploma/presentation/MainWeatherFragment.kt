package com.example.forecast_diploma.presentation

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.forecast_diploma.R
import com.example.forecast_diploma.databinding.FragmentMainWeatherBinding
import com.example.forecast_diploma.presentation.model.WeatherModel
import com.example.forecast_diploma.presentation.adapter.ListWeatherAdapter
import com.example.forecast_diploma.presentation.adapter.WeatherListener
import com.example.forecast_diploma.utils.Constans.COUNTRY
import com.example.forecast_diploma.utils.Constans.HUMIDITY
import com.example.forecast_diploma.utils.Constans.ICON
import com.example.forecast_diploma.utils.Constans.MAX_T
import com.example.forecast_diploma.utils.Constans.MIN_T
import com.example.forecast_diploma.utils.Constans.NAME
import com.example.forecast_diploma.utils.Constans.REGION
import com.example.forecast_diploma.utils.Constans.TEMP_C
import com.example.forecast_diploma.utils.Constans.TEXT
import com.example.forecast_diploma.utils.Constans.TIME
import com.squareup.picasso.Picasso


import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainWeatherFragment : Fragment(), WeatherListener {

    private var _binding: FragmentMainWeatherBinding? = null
    private val binding: FragmentMainWeatherBinding get() = _binding!!
    private val viewModel: MainWeatherViewModel by viewModels()
    private lateinit var weatherAdapter: ListWeatherAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainWeatherBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getListWeather()

        weatherAdapter = ListWeatherAdapter(this)

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = weatherAdapter

        viewModel.currentWeather.observe(viewLifecycleOwner) { listItems ->
            weatherAdapter.submitList(listItems)
        }

        viewModel.bundle.observe(viewLifecycleOwner) { weather ->
            if (weather != null) {
                val bundle = Bundle()
                bundle.putString(TIME, weather.time)
                bundle.putString(NAME, weather.name)
                bundle.putString(COUNTRY, weather.country)
                bundle.putString(REGION, weather.region)
                bundle.putString(TEXT, weather.text)
                bundle.putString(TEMP_C, weather.temp_c.toString())
                bundle.putString(ICON, weather.icon)
                bundle.putString(HUMIDITY,weather.humidity.toString())
                bundle.putString(MAX_T,weather.max_t.toString())
                bundle.putString(MIN_T,weather.min_t.toString())

                findNavController().navigate(R.id.action_mainWeatherFragment_to_currentWeatherFragment,
                bundle)

            }
        }
    }

    override fun onElementClick(
        name: String,
        region: String,
        country: String,
        temp_c: Double,
        text: String,
        icon: String,
        time: String,
         max_t:Int,
         min_t:Int,
       humidity: Int,
    ) {
      viewModel.elementClicked(name, region, country, temp_c, text, icon, time,max_t, min_t, humidity)
    }
}


