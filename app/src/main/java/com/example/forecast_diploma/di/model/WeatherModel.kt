package com.example.forecast_diploma.di.model

import com.example.forecast_diploma.data.model.Condition

data class WeatherModel(

    val name: String,
    val region: String,
    val country: String,
    val temp_c: Double,
  //  val condition: String,
    val text: String,
    val icon:String,
    val localtime: String
)