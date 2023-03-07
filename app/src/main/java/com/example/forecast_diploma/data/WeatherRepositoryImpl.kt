package com.example.forecast_diploma.data


import android.util.Log
import com.example.forecast_diploma.di.DataModule.Companion.API_KEY
import com.example.forecast_diploma.di.model.WeatherModel
import com.example.forecast_diploma.domain.WeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val apiServise: WeatherApiServise,

) : WeatherRepository {

    override suspend fun getListCityWeather(): List<WeatherModel> {
        return withContext(Dispatchers.IO) {
            val response = apiServise.getListCityWeather()
            Log.w("Resp repoImpl", response.body()?.bulkList.toString())
            response.body()?.bulkList?.let {
                it.map {
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
            } ?: kotlin.run {
              emptyList()
            }
        }
    }
}
