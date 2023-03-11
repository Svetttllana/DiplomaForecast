package com.example.forecast_diploma.data


import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.forecast_diploma.data.database.FavoritesEntity
import com.example.forecast_diploma.data.database.WeatherEntity
import com.example.forecast_diploma.data.database.dao.WeatherDAO
import com.example.forecast_diploma.data.network.InternetConnection
import com.example.forecast_diploma.data.sharedprefs.SharedPreferencesHelper
import com.example.forecast_diploma.domain.WeatherRepository
import com.example.forecast_diploma.presentation.model.FavoriteModel
import com.example.forecast_diploma.presentation.model.WeatherModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val apiServise: WeatherApiServise,
    private val weatherDAO: WeatherDAO,
    private val internetConnection: InternetConnection,
    private val sharedPreferencesHelper: SharedPreferencesHelper

) : WeatherRepository {

    override suspend fun getListCityWeather() {

        return withContext(Dispatchers.IO) {
            val response = apiServise.getListCityWeather()
            Log.w("Response repoImpl", response.body()?.bulkList.toString())
            response.body()?.bulkList?.let {
                it.map {
                    val weatherEntity = WeatherEntity(
                        it.current.id,
                        it.current.time,
                        it.current.cloud,
                        it.current.is_day,
                        it.current.max_t,
                        it.current.min_t,
                        it.current.temp_c,
                        it.current.temp_f,
                        it.current.vis_km,
                        it.current.gust_kph,
                        it.current.gust_mph,
                        it.current.humidity,
                        it.current.wind_dir,
                        it.current.wind_kph,
                        it.current.wind_mph,
                        it.current.precip_in,
                        it.current.precip_mm,
                        it.current.vis_miles,
                        it.current.time_epoch,
                        it.current.feelslike_c,
                        it.current.feelslike_f,
                        it.current.pressure_in,
                        it.current.pressure_mb,
                        it.current.wind_degree,
                        it.location.name,
                        it.location.region,
                        it.location.country,
                        it.location.lat,
                        it.location.lon,
                        it.location.tz_id,
                        it.location.localtime_epoch,
                        it.location.localtime,
                        it.current.condition.code,
                        it.current.condition.icon,
                        it.current.condition.text,
                    )
                    weatherDAO.insertWeatherEntity(weatherEntity)

                    WeatherModel(
                        it.location.name,
                        it.location.region,
                        it.location.country,
                        it.current.temp_c,
                        it.current.condition.text,
                        it.current.condition.icon,
                        it.current.time,
                        it.current.max_t,
                        it.current.min_t,
                        it.current.humidity
                    )
                }
            }
        }
    }

    override suspend fun showData(): List<WeatherModel> {
        return withContext(Dispatchers.IO) {
            val it = weatherDAO.getWeatherEntity()
            it.map {
                WeatherModel(
                    it.name,
                    it.region,
                    it.country,
                    it.temp_c,
                    it.text,
                    it.icon,
                    it.time,
                    it.max_t,
                    it.min_t,
                    it.humidity
                )
            }
        }
    }

    override suspend fun findWeatherByName(searchText: String): WeatherModel {
        return withContext(Dispatchers.IO) {
            val weatherEntity = weatherDAO.findWeatherByName(searchText)
            WeatherModel(
                weatherEntity.name,
                weatherEntity.region,
                weatherEntity.country,
                weatherEntity.temp_c,
                weatherEntity.text,
                weatherEntity.icon,
                weatherEntity.time,
                weatherEntity.max_t,
                weatherEntity.min_t,
                weatherEntity.humidity
            )
        }
    }

    override suspend fun onweatherFanClicked(name: String) {
        return withContext(Dispatchers.IO) {
            val favEntity = weatherDAO.findFavoriteEntityById(name)
            weatherDAO.insertFavoritesEntity(
                FavoritesEntity(
                    favEntity.id,
                    favEntity.name,
                    favEntity.cloud,
                    favEntity.is_day,
                    favEntity.max_t,
                    favEntity.min_t,
                    favEntity.temp_c,
                    favEntity.temp_f,
                    favEntity.vis_km,
                    favEntity.gust_kph,
                    favEntity.gust_mph,
                    favEntity.humidity,
                    favEntity.wind_dir,
                    favEntity.wind_kph,
                    favEntity.wind_mph,
                    favEntity.precip_in,
                    favEntity.precip_mm,
                    favEntity.vis_miles,
                    favEntity.time_epoch,
                    favEntity.feelslike_c,
                    favEntity.feelslike_f,
                    favEntity.pressure_in,
                    favEntity.pressure_mb,
                    favEntity.wind_degree,
                    favEntity.name,
                    favEntity.region,
                    favEntity.country,
                    favEntity.lat,
                    favEntity.lon,
                    favEntity.tz_id,
                    favEntity.localtime_epoch,
                    favEntity.localtime,
                    favEntity.code,
                    favEntity.icon,
                    favEntity.text,
                )
            )

        }
    }

    override suspend fun fetFavorites(): Flow<List<FavoriteModel>> {
        return withContext(Dispatchers.IO) {
            val favoritesEntity = weatherDAO.getFavoritesEntities()
            favoritesEntity.map {
                it.map {
                    FavoriteModel(
                        it.name,
                        it.temp_c,
                        it.text,
                        it.icon
                    )
                }

            }
        }
    }

    override suspend fun deliteFavByName(name: String) {
        return withContext(Dispatchers.IO) {
            weatherDAO.deliteFavByName(name)
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override suspend fun networkAccess(): Boolean {
        return withContext(Dispatchers.IO){
            internetConnection.isOnline()
        }
    }

    override suspend fun saveBlackTheme(isSave: Boolean) {
        withContext(Dispatchers.IO){
            sharedPreferencesHelper.saveBlackTheme(isSave)
        }
    }
}

