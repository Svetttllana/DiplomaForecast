package com.example.forecast_diploma.di.model

data class WeatherModel(

    val name: String,
    val region: String,
    val country: String,
    val temp_c: Double,
    val condition: String,
    val text: String
)