package com.example.forecast_diploma.domain

import android.util.Log
import com.example.forecast_diploma.di.model.FutureWeatherModel
import com.example.forecast_diploma.di.model.WeatherModel
import javax.inject.Inject

class WeatherInteractor @Inject constructor(
    private val weatherRepository: WeatherRepository
) {


   suspend fun getListWeather():List<WeatherModel> {
       Log.w("RESPONSE","RESPONSE VIZVAN iz interactora")
        return weatherRepository.getListCityWeather()
    }

    //ьщжет знак вопроса и не обязателен
    suspend fun getForecastData():List<FutureWeatherModel>{
        return weatherRepository.getForecastData()
    }


}