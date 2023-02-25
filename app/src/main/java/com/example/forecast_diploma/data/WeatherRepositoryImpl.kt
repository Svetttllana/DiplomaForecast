package com.example.forecast_diploma.data


import android.util.Log
import com.example.forecast_diploma.di.DataModule.Companion.API_KEY
import com.example.forecast_diploma.di.model.WeatherModel
import com.example.forecast_diploma.domain.WeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val apiServise: WeatherApiServise
) : WeatherRepository {

    override suspend fun getCurrentData(): WeatherModel? {
        Log.w("RESPONSE", "RESPONSE VIZVAN0")
        return withContext(Dispatchers.IO) {
            val response = apiServise.getCurrentWeatherbyCity(API_KEY,"Grodno")
            Log.w("RESPONSE", response.body().toString())
            response.body()?.let {
                WeatherModel(
                    it.location.country,
                    it.location.region,
                    it.location.name,
                    it.current.temp_c,
                    it.current.condition.icon,
                    it.current.condition.text

                )
            } ?: kotlin.run { null }
        }
    }
}


// Log.w("RESPONSE",response.body().toString())
//            val response = apiServise.getCurrentWeatherbyCity(API_KEY,"Minsk")
//
//            response.body()?.let {
//
//                it.map {
//                    WeatherModel(
//                        it.location.country,
//                        it.location.region,
//                        it.location.name,
//                        it.current.temp_c,
//                        it.current.condition.icon,
//                        it.current.condition.text
//                    )
//                }
//            }
//        } ?: kotlin.run {
//            emptyList()
//        }


