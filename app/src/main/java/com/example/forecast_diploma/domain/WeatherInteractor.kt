package com.example.forecast_diploma.domain

import android.util.Log
import com.example.forecast_diploma.di.model.FutureWeatherModel
import com.example.forecast_diploma.di.model.WeatherModel
import javax.inject.Inject

class WeatherInteractor @Inject constructor(
    private val weatherRepository: WeatherRepository
) {


    suspend fun getListWeather() {
        return weatherRepository.getListCityWeather()
    }

    suspend fun showWeatherData():List<WeatherModel>{
        return  weatherRepository.showData()
    }

}