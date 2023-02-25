package com.example.forecast_diploma.data.model

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    val location: Location,
    val current: Current,
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

data class Current(
    val last_updated_epoch: Int,
    val last_updated: String,
    val temp_c: Double,
    val temp_f: Double,
    val is_day: Int,
    val condition: Condition,
    val wind_mph: Double,
    val wind_kph: Double,
    val wind_degree: Int,
    val wind_dir: String,
    val pressure_mb: Double,
    val pressure_in: Double,
    val precip_mm: Double,
    val precip_in: Double,
    val humidity: Int,
    val cloud: Int,
    val feelslike_c: Double,
    val feelslike_f: Double,
    val vis_km: Double,
    val vis_miles: Double,
    val uv: Double,
    val gust_mph: Double,
    val gust_kph: Double
)


data class Condition(
    val text: String,
    val icon: String,
    val code: Int
)


//@SerializedName("weather")
//    val weather:List<Weather>,
//
//    @SerializedName("main")
//    val main:Main,
//    @SerializedName("wind")
//    val wind:Wind,
//    @SerializedName("sys")
//    val sys:Sys,
//    @SerializedName("id")
//    val id:Int,
//    @SerializedName("name")
//    val name:String
//
//)
//
//data class Weather(
//    @SerializedName("id")
//    val id:Int,
//    @SerializedName("main")
//    val main:String,
//    @SerializedName("description")
//    val description:String,
//    @SerializedName("icon")
//    val icon:String,
//)
//
//data class Main(
//@SerializedName("temp")
//val temp:Double,
//@SerializedName("feels_like")
//val feels_like:Double,
//@SerializedName("temp_min")
//val temp_min:Double,
//@SerializedName("temp_max")
//val temp_max:Double,
//@SerializedName("pressure")
//val pressure:Int,
//@SerializedName("humidity")
//val humidity:Int,
//@SerializedName("sea_level")
//val sea_level:Int,
//@SerializedName("grnd_level")
//val grnd_level:Int
//
//)
//
//
//data class Wind(
//    @SerializedName("speed")
//    val speed:Double,
//    @SerializedName("deg")
//    val deg:Int,
//    @SerializedName("gust")
//    val gust:Double
//)
//
//
//data class Sys(
//    @SerializedName("type")
//    val type:Int,
//    @SerializedName("id")
//    val id:Int,
//    @SerializedName("country")
//    val country:String,
//    @SerializedName("sunrise")
//    val sunrise:Int,
//    @SerializedName("sunset")
//    val sunset:Int)
