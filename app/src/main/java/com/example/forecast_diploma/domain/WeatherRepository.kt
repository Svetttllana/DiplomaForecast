package com.example.forecast_diploma.domain

import com.example.forecast_diploma.di.model.NewWeatherModel
import com.example.forecast_diploma.di.model.WeatherModel

interface WeatherRepository {

   suspend fun getCurrentData():WeatherModel?
}