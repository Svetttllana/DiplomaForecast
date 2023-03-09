package com.example.forecast_diploma.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.Query
import com.example.forecast_diploma.data.database.WeatherEntity
import com.example.forecast_diploma.di.model.WeatherModel


@Dao
interface WeatherDAO {



    @Insert(onConflict = IGNORE)
    fun insertWeatherEntity(weatherEntity: WeatherEntity)

    @Query("SELECT * From WeatherEntity")
    fun getWeatherEntity():List<WeatherModel>

    @Query("SELECT * FROM WeatherEntity WHERE name =:searchText")
    fun findWeatherByName(searchText:String):WeatherEntity

}