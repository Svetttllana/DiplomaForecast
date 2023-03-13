package com.example.forecast_diploma.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.forecast_diploma.presentation.model.WeatherModel
import com.example.forecast_diploma.domain.WeatherInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainWeatherViewModel @Inject constructor(
    private val weatherInteractor: WeatherInteractor
) : ViewModel() {

    private val _currentWeather = MutableLiveData<List<WeatherModel>>()
    val currentWeather: LiveData<List<WeatherModel>> = _currentWeather


    private val _bundle = MutableLiveData<WeatherBundle?>()
    val bundle: LiveData<WeatherBundle?> = _bundle


    fun getListWeather() {
        viewModelScope.launch {
            try {
                weatherInteractor.getListWeather()
                val listWeather = weatherInteractor.showWeatherData()
                _currentWeather.value = listWeather
            } catch (e: Exception) {
                Log.w("getCurrentData", e.message.toString())
            }
        }
    }


    fun elementClicked(
        name: String,
        region: String,
        country: String,
        temp_c: Double,
        text: String,
        icon: String,
        time: String,
        max_t: Int,
        min_t: Int,
        humidity: Int,
    ) {

        _bundle.value = WeatherBundle(
            name, region, country, temp_c, text, icon, time, max_t, min_t, humidity
        )


    }

}

data class WeatherBundle(
    val name: String,
    val region: String,
    val country: String,
    val temp_c: Double,
    val text: String,
    val icon: String,
    val time: String,
    val max_t: Int,
    val min_t: Int,
    val humidity: Int
)