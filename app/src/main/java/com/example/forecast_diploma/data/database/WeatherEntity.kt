package com.example.forecast_diploma.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.forecast_diploma.data.model.Condition

@Entity("WeatherEntity")
data class WeatherEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo("id")
     val id: Int,
    @ColumnInfo("time")
    val time: String,
    @ColumnInfo("cloud")
    val cloud: Int,
    @ColumnInfo("is_day")
    val is_day: Int,
    @ColumnInfo("max_t")
    val max_t:Int,
    @ColumnInfo("min_t")
    val min_t:Int,
    @ColumnInfo("temp_c")
    val temp_c: Double,
    @ColumnInfo("temp_f")
    val temp_f: Double,
    @ColumnInfo("vis_km ")
    val vis_km: Int,
    @ColumnInfo("gust_kph")
    val gust_kph: Double,
    @ColumnInfo("gust_mph")
    val gust_mph: Double,
    @ColumnInfo("humidity")
    val humidity: Int,
    @ColumnInfo("wind_dir")
    val wind_dir: String,
    @ColumnInfo("wind_kph")
    val wind_kph: Double,
    @ColumnInfo("wind_mph")
    val wind_mph: Double,

    @ColumnInfo("precip_in")
    val precip_in: Int,
    @ColumnInfo("precip_mm")
    val precip_mm: Int,
    @ColumnInfo("vis_miles")
    val vis_miles: Int,
    @ColumnInfo("time_epoch")
    val time_epoch: Int,
    @ColumnInfo("feelslike_c")
    val feelslike_c: Double,
    @ColumnInfo("feelslike_f")
    val feelslike_f: Double,
    @ColumnInfo("pressure_in")
    val pressure_in: Double,
    @ColumnInfo("pressure_mb")
    val pressure_mb: Int,
    @ColumnInfo("wind_degree")
    val wind_degree: Int,
    @ColumnInfo("name")
    val name: String,
    @ColumnInfo("region")
    val region: String,
    @ColumnInfo("country")
    val country: String,
    @ColumnInfo("lat")
    val lat: Double,
    @ColumnInfo("lon")
    val lon: Double,
    @ColumnInfo("tz_id")
    val tz_id: String,
    @ColumnInfo("localtime_epoch")
    val localtime_epoch: Int,
    @ColumnInfo("localtime")
    val localtime: String,
    @ColumnInfo("code")
    val code: Int,
    @ColumnInfo("icon")
    val icon: String,
    @ColumnInfo("text")
    val text: String,
    )
