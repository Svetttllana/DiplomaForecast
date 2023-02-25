package com.example.forecast_diploma.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.forecast_diploma.di.model.NewWeatherModel
import com.example.forecast_diploma.di.model.WeatherModel
import com.example.forecast_diploma.domain.WeatherInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainWeatherViewModel @Inject constructor(
    private val weatherInteractor: WeatherInteractor
    ) :ViewModel() {

        private val _currentWeather = MutableLiveData<WeatherModel?>()
    val currentWeather: LiveData<WeatherModel?>  = _currentWeather


   fun getCurrentData(){
       viewModelScope.launch {
           try {
               val listWeather =  weatherInteractor.getCurrentData()
               _currentWeather.value= listWeather
           }catch (e:Exception){
               Log.w("getCurrentData",e.message.toString())
           }
       }

    }


}