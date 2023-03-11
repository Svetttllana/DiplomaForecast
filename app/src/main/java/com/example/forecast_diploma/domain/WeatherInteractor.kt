package com.example.forecast_diploma.domain

import com.example.forecast_diploma.presentation.model.FavoriteModel
import com.example.forecast_diploma.presentation.model.WeatherModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WeatherInteractor @Inject constructor(
    private val weatherRepository: WeatherRepository
) {


    suspend fun getListWeather() {
        return weatherRepository.getListCityWeather()
    }

    suspend fun showWeatherData():List<WeatherModel>{
        return  weatherRepository.showData()
    }

    suspend fun findWeather(searchText:String): WeatherModel {
        return  weatherRepository.findWeatherByName(searchText)
    }

    suspend fun weatherFanClicked(name:String){
        weatherRepository.onweatherFanClicked(name)
    }

    suspend fun getFavorite(): Flow<List<FavoriteModel>> {
        return weatherRepository.fetFavorites()
    }

    suspend fun deliteFavByName(name:String){
        return weatherRepository.deliteFavByName(name)
    }

    suspend fun networkAccess():Boolean{
        return  weatherRepository.networkAccess()
    }

   suspend fun saveBlackTheme(isSave: Boolean){
       return weatherRepository.saveBlackTheme(isSave)
   }

}