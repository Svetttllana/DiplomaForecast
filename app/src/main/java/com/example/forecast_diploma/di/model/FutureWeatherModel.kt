package com.example.forecast_diploma.di.model

data class FutureWeatherModel(
//    val city:String,
//    val time: Double,
  //  val condition: String,
  //  val currentTemperature:String,
    val date: String,
    val maxtemp_c:Double,
    val mintemp_c: Double,
    val text:String,
    val icon:String,

    //  val hours:String
    val temp_c: Double,

)