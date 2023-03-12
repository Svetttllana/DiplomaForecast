package com.example.forecast_diploma.data

import com.example.forecast_diploma.data.model.WeatherResponse
import retrofit2.Response
import retrofit2.http.*

interface WeatherApiServise {


    @GET("/JQcL4D")
    suspend fun getListCityWeather(): Response<WeatherResponse>

}