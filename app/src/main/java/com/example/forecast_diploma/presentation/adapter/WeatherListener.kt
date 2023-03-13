package com.example.forecast_diploma.presentation.adapter

interface WeatherListener {

    fun onElementClick(
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
    )
}