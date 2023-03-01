package com.example.forecast_diploma.data

import com.example.forecast_diploma.data.model.FutureWeatherResponse
import com.example.forecast_diploma.data.model.WeatherResponse
import com.example.forecast_diploma.di.DataModule.Companion.API_KEY
import com.example.forecast_diploma.di.model.WeatherModel
import retrofit2.Response
import retrofit2.http.GET

import retrofit2.http.Query



//http://api.weatherapi.com/v1/current.json?key=32b99295f5e644ecb91195115230802&q=Minsk&aqi=no


//http://api.weatherapi.com/v1/forecast.json?key=767cf706cf0a4b9d8dc141442232702&q=London&days=3&aqi=no&alerts=no

interface WeatherApiServise {


    @GET("/v1/current.json")
    suspend fun getCurrentWeatherbyCity(
        @Query("key") key: String,
        @Query("q") city: String
    ): Response<WeatherResponse>


    @GET("/v1/forecast.json")
    suspend fun getForecastWeatherbyCity(
        @Query("key") key: String,
        @Query("q") city: String,
        @Query("days") days: String
    ): Response<FutureWeatherResponse>


//        @GET("data/2.5/weather")
//   suspend fun getCityWeatherData(
//            @Query("q") cityName: String,
//            @Query("appid") api_key: String,
//    ):Response<WeatherResponse>


}


//    @GET("weather")
//    fun getCurrentWeatherData(
//        @Query("lat") latitude: String,
//        @Query("lon") longitude: String,
//        @Query("appid") api_key: String=API_KEY,
//    ):Response<WeatherResponse>
//
//


//    companion object{
//        private const val BASE_URL ="http://api.weatherapi.com"
//        operator fun invoke():WeatherApiServise{
//            val requestInterseptor = Interceptor{chain ->
//
//                val url = chain.request()
//                    .url()
//                    .newBuilder()
//                    .addQueryParameter( "key", API_KEY   )
//                    .build()
//
//                val request = chain.request()
//                    .newBuilder()
//                    .url(url)
//                    .build()
//                return@Interceptor chain.proceed(request)
//            }
//
//            val okHttpClient = OkHttpClient.Builder()
//                .addInterceptor(requestInterseptor)
//                .build()
//
//                    return Retrofit.Builder()
//                        .client(okHttpClient)
//                .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//                        .create(WeatherApiServise::class.java)
//        }
//    }





