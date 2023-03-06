package com.example.forecast_diploma.data

import com.example.forecast_diploma.data.model.WeatherResponse
import retrofit2.Response
import retrofit2.http.*


//https://api.jsonserve.com/UrRXCP
interface WeatherApiServise {


    @GET("/UrRXCP")
    suspend fun getListCityWeather(): Response<WeatherResponse>

}