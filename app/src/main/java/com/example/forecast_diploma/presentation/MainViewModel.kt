package com.example.forecast_diploma.presentation

import androidx.lifecycle.ViewModel
import com.example.forecast_diploma.domain.WeatherInteractor

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor
    (
    private val weatherInteractor: WeatherInteractor
)
    :ViewModel() {

}