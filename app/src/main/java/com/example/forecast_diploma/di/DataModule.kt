package com.example.forecast_diploma.di

import android.content.Context
import android.util.Log

import com.example.forecast_diploma.data.WeatherApiServise
import com.example.forecast_diploma.data.WeatherRepositoryImpl
import com.example.forecast_diploma.data.sharedprefs.SharedPreferencesHelper
import com.example.forecast_diploma.domain.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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

    companion object{
        private const val BASE_URL ="https://api.jsonserve.com"
        private const val SP_KEY = "SP_KEY"

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

        @Provides
        fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferencesHelper {
            return SharedPreferencesHelper(context.getSharedPreferences(SP_KEY, Context.MODE_PRIVATE))
        }

    }

}