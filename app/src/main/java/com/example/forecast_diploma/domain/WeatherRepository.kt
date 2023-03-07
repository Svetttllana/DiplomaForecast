package com.example.forecast_diploma.domain

import com.example.forecast_diploma.di.model.WeatherModel

interface WeatherRepository {

   suspend fun getListCityWeather():List<WeatherModel>
}