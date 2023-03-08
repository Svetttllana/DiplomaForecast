package com.example.forecast_diploma.data.model

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("bulk")
    val bulkList: List<Bulk>,
)

data class Bulk(
    val current: Current,
    val location: Location,
    )

data class Current(
    val id: Int,
    val time: String,
    val cloud: Int,
   val is_day: Int,
    val max_t:Int,
    val min_t:Int,
    val temp_c: Double,
    val temp_f: Double,
    val vis_km: Int,
    val gust_kph: Double,
    val gust_mph: Double,
    val humidity: Int,
    val wind_dir: String,
    val wind_kph: Double,
    val wind_mph: Double,
    val condition: Condition,
    val precip_in: Int,
    val precip_mm: Int,
    val vis_miles: Int,
    val time_epoch: Int,
    val feelslike_c: Double,
    val feelslike_f: Double,
    val pressure_in: Double,
    val pressure_mb: Int,
    val wind_degree:Int
)

data class Location(
    val name: String,
    val region: String,
    val country: String,
    val lat: Double,
    val lon: Double,
    val tz_id: String,
    val localtime_epoch: Int,
    val localtime: String

)
data class Condition(
    val code: Int,
    val icon: String,
    val text: String,
)

