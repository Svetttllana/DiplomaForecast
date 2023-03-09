package com.example.forecast_diploma.di.model

data class WeatherModel(


    val name: String,
    val region: String,
    val country: String,
    val temp_c: Double,
    val text: String,
    val icon: String,
    val time: String,
    val max_t:Int,
    val min_t:Int,
    val humidity: Int,


)