package com.example.forecast_diploma.di

import android.util.Log

import com.example.forecast_diploma.data.WeatherApiServise
import com.example.forecast_diploma.data.WeatherRepositoryImpl
import com.example.forecast_diploma.domain.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindWeatherRepository(
        weatherRepositoryImpl: WeatherRepositoryImpl
    ): WeatherRepository

    //http:api.weatherapi.com/v1/current.json?key=32b99295f5e644ecb91195115230802&q=Minsk&aqi=no

    companion object{
        private const val BASE_URL ="https://api.weatherapi.com"
       const val API_KEY = "32b99295f5e644ecb91195115230802"

        //private const val BASE_URL = "https://api.openweathermap.org/"
//        const val API_KEY = "18a2ec2a57e36fdf22a5be425dec0414"
        @Provides
        fun provideWeatherApiServise(retrofit: Retrofit):WeatherApiServise{
            return retrofit.create(WeatherApiServise::class.java)
        }

        @Provides
        fun provideRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()



        }


    }

}