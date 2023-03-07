package com.example.forecast_diploma.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.forecast_diploma.di.model.FutureWeatherModel
import com.example.forecast_diploma.di.model.WeatherModel
import com.example.forecast_diploma.domain.WeatherInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DaysWeatherViewModel @Inject constructor(
    private val weatherInteractor: WeatherInteractor
    ):ViewModel() {

    private val _days = MutableLiveData<List<FutureWeatherModel>>()
    val days: LiveData<List<FutureWeatherModel>> = _days



}