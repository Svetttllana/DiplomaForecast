package com.example.forecast_diploma.data


import android.util.Log
import androidx.lifecycle.Transformations.map
import androidx.room.ColumnInfo
import com.example.forecast_diploma.data.database.WeatherEntity
import com.example.forecast_diploma.data.database.dao.WeatherDAO
import com.example.forecast_diploma.data.model.Condition
import com.example.forecast_diploma.di.model.WeatherModel
import com.example.forecast_diploma.domain.WeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val apiServise: WeatherApiServise,
    private val weatherDAO: WeatherDAO

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
                        it.current.time
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
                    it.time
                )
            }


        }
    }
}

