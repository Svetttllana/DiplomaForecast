package com.example.forecast_diploma.di

import com.example.forecast_diploma.domain.WeatherInteractor
import com.example.forecast_diploma.domain.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)

class DomainModule {

    @Provides
    fun provideWeatherInteractor(
        weatherRepository: WeatherRepository
    ):WeatherInteractor{
        return WeatherInteractor(weatherRepository)
    }

}