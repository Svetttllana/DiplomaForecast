package com.example.forecast_diploma.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.forecast_diploma.di.model.WeatherModel
import com.example.forecast_diploma.domain.WeatherInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainWeatherViewModel @Inject constructor(
    private val weatherInteractor: WeatherInteractor
    ) :ViewModel() {

        private val _currentWeather = MutableLiveData<List<WeatherModel>>()
    val currentWeather: LiveData<List<WeatherModel>>  = _currentWeather


    private val _bundle = MutableLiveData<NavigateWithBundle?>()
    val bundle: LiveData<NavigateWithBundle?> = _bundle


   fun getListWeather(){
       viewModelScope.launch {
           try {
               val listWeather =  weatherInteractor.getListWeather()
               _currentWeather.value = listWeather
           }catch (e:Exception){
               Log.w("getCurrentData",e.message.toString())
           }
       }
    }
}



data class NavigateWithBundle(
    val name: String,
    val region: String,
    val country: String,
    val temp_c: Double,
    // val condition: String,
    val text: String,
    val icon:String,
    val time:String

)