package com.example.forecast_diploma.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.Query
import com.example.forecast_diploma.data.database.FavoritesEntity
import com.example.forecast_diploma.data.database.WeatherEntity
import com.example.forecast_diploma.presentation.model.WeatherModel
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDAO {
    @Insert(onConflict = IGNORE)
    fun insertWeatherEntity(weatherEntity: WeatherEntity)

    @Query("SELECT * From WeatherEntity")
    fun getWeatherEntity(): List<WeatherModel>

    @Query("SELECT * FROM WeatherEntity WHERE name =:searchText")
    fun findWeatherByName(searchText: String): WeatherEntity

    @Query("SELECT * FROM WeatherEntity WHERE name =:name")
    fun findFavoriteEntityById(name: String): WeatherEntity

    @Query("DELETE  FROM FavoritesEntity WHERE name =:name")
    fun deliteFavByName(name: String)

    @Insert(onConflict = IGNORE)
    fun insertFavoritesEntity(favoriteEntity: FavoritesEntity)

    @Query("SELECT * FROM FavoritesEntity")
    fun getFavoritesEntities(): Flow<List<FavoritesEntity>>

}