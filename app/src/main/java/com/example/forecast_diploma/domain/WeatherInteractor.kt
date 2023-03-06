package com.example.forecast_diploma.domain

import android.util.Log
import com.example.forecast_diploma.di.model.NewWeatherModel
import com.example.forecast_diploma.di.model.WeatherModel
import javax.inject.Inject

class WeatherInteractor @Inject constructor(
    private val weatherRepository: WeatherRepository
) {


   suspend fun getListWeather():List<WeatherModel> {
       Log.w("RESPONSE","RESPONSE VIZVAN iz interactora")
        return weatherRepository.getListCityWeather()
    }


}