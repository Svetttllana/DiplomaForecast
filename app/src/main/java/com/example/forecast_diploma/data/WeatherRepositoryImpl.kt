package com.example.forecast_diploma.data


import android.util.Log
import com.example.forecast_diploma.di.DataModule.Companion.API_KEY
import com.example.forecast_diploma.di.model.FutureWeatherModel
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
            val response = apiServise.getCurrentWeatherbyCity(API_KEY, "Minsk")
            Log.w("RESPONSE", response.body().toString())
            response.body()?.let {
                WeatherModel(
                    it.location.name,
                    it.location.region,
                    it.location.country,
                    it.current.temp_c,
                    it.current.condition.text,
                    it.current.condition.icon,
                    it.location.localtime

                )
            } ?: kotlin.run { null }
        }
    }

    override suspend fun getForecastData(): List<FutureWeatherModel> {
        return withContext(Dispatchers.IO) {
            val resp = apiServise.getForecastWeatherbyCity(API_KEY, "Minsk", "3")
            Log.w("getForecastData", resp.body().toString())
            resp.body()?.forecast?.forecastday?.let {
                it.map {
                    FutureWeatherModel(
                        it.date,
                        it.day.maxtemp_c,
                        it.day.mintemp_c,
                        it.day.condition.text,
                        it.day.condition.icon,
                        it.hour[2].temp_c
                    )
                }

            } ?: kotlin.run {
                emptyList()
            }
        }
    }
}




//val mapped = collection.nestedCollection . map{ outher->
//    Collection2(
//        collection.coll,
//        listOf(NestedCollection2(outher.stringList))
//
//    )
//}
//log.w("mapped nested",mapped.toString)


//override suspend fun getData(): List<ItemsModel> {
//
//    return withContext(Dispatchers.IO) {
//
//        val response = apiService.getData()
//        response.body()?.sampleList?.let {
//            it.map {
//                ItemsModel(it.description, it.imageUrl)
//            }
//        } ?: kotlin.run {
//            emptyList()
//        }
//    }
//}


