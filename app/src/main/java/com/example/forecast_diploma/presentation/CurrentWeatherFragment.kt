package com.example.forecast_diploma.presentation

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.forecast_diploma.databinding.FragmentCurrentWeatherBinding
import com.example.forecast_diploma.di.model.WeatherModel
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
class CurrentWeatherFragment() : Fragment() {

    private var _binding: FragmentCurrentWeatherBinding? = null
    private val binding: FragmentCurrentWeatherBinding get() = _binding!!
//  private val viewModel: CurrentWeatherViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCurrentWeatherBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = arguments

        bundle?.let { safeBundle ->

            val name = safeBundle.getString(NAME)
            val region = safeBundle.getString(REGION)
            val country = safeBundle.getString(COUNTRY)
            val temperature = safeBundle.getString(TEMP_C)
            val condition = safeBundle.getString(TEMP_C)
            val icon = safeBundle.getString("icon")
            val max_t = safeBundle.getString(MAX_T)
            val min_t = safeBundle.getString(MIN_T)
            val humidity = safeBundle.getString(HUMIDITY)

            binding.tvCityName.text=name
            binding.region.text=region
            binding.country.text=country
            binding.tempersture.text=temperature+"C"
            binding.condition.text=condition
            binding.tvMaxMin.text="${max_t}/"+"${min_t}"
            binding.tvHumidity.text=humidity

            //Picasso.get().load("https:" + Uri.parse(icon)).into(binding.imWeatherIcon)
            Picasso.get().load("https:"+icon).into(binding.imWeatherIcon)
        }

    }



}










//            bundle.putString(TIME, weather.time)
//            bundle.putString(NAME, weather.name)
//            bundle.putString(COUNTRY, weather.country)
//            bundle.putString(REGION, weather.region)
//            bundle.putString(TEXT, weather.text)
//            bundle.putString(TEMP_C, weather.temp_c.toString())
//            bundle.putString(ICON, weather.icon)

//            binding.date.text=safeBundle.getString(TIME)
//            binding.tvCityName.text=safeBundle.getString(NAME)
//            binding.country.text=safeBundle.getString(COUNTRY)
//            binding.region.text=safeBundle.getString(REGION)
//            binding.condition.text=safeBundle.getString(TEXT)
//            binding.tempersture.text=safeBundle.getString(TEMP_C)+"C"
//  Picasso.get().load("https:" +safeBundle.getString(ICON)).into(binding.tvWeatherIcon)

// binding.tvWeatherIcon=safeBundle.getBundle(ICON)
//