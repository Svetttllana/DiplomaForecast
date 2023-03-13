package com.example.forecast_diploma.domain

import com.example.forecast_diploma.presentation.model.FavoriteModel
import com.example.forecast_diploma.presentation.model.WeatherModel
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {

   suspend fun getListCityWeather()

   suspend fun showData():List<WeatherModel>

   suspend fun findWeatherByName(searchText:String): WeatherModel

   suspend fun weatherFanClicked(name:String)

   suspend fun fetFavorites(): Flow<List<FavoriteModel>>

   suspend fun deliteFavByName(name:String)

   suspend fun networkAccess():Boolean

   suspend fun saveBlackTheme(save: Boolean)
}