package com.example.forecast_diploma.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.forecast_diploma.domain.WeatherInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CurrentWeatherViewModel @Inject constructor(
    private val weatherInteractor: WeatherInteractor
) : ViewModel() {


    fun onFavClicked(name: String) {
        viewModelScope.launch {
            weatherInteractor.weatherFanClicked(name)
        }
    }

}