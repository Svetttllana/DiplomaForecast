package com.example.forecast_diploma.domain

import com.example.forecast_diploma.di.model.FutureWeatherModel
import com.example.forecast_diploma.di.model.WeatherModel

interface WeatherRepository {

   suspend fun getCurrentData():WeatherModel?

   suspend fun getForecastData():List<FutureWeatherModel>
}