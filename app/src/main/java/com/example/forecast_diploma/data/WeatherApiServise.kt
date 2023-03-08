package com.example.forecast_diploma.data

import com.example.forecast_diploma.data.model.WeatherResponse
import retrofit2.Response
import retrofit2.http.*

//const val API_KEY = "32b99295f5e644ecb91195115230802"

//https://api.jsonserve.com/JQcL4D
interface WeatherApiServise {


    @GET("/JQcL4D")
    suspend fun getListCityWeather(): Response<WeatherResponse>

}