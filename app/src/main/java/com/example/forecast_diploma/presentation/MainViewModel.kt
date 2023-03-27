package com.example.forecast_diploma.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.forecast_diploma.domain.WeatherInteractor
import com.example.forecast_diploma.presentation.model.FavoriteModel

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor
    (
    private val weatherInteractor: WeatherInteractor
) : ViewModel() {

    private val _network = MutableLiveData<Boolean>()
    val network: LiveData<Boolean> = _network

    private val _darkTeme = MutableLiveData<Boolean>()
    val darkTeme = _darkTeme

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun networkAccess() {
        viewModelScope.launch {
            try {
                _network.value = weatherInteractor.networkAccess()
            } catch (e: Exception) {
                Log.w("networkAccess", e.message.toString())
            }
        }
    }


    fun saveDarkTem() {
        viewModelScope.launch {
            try {
                weatherInteractor.saveBlackTheme()
            } catch (e: Exception) {
                _error.value = e.message.toString()
            }
        }
    }

    fun checkTeme(isCheckd: Boolean) {
        viewModelScope.launch {
            try {
                weatherInteractor.checkTeme(isCheckd)
                val darkTeme = !(darkTeme.value ?: false)
                _darkTeme.value = darkTeme
            } catch (e: Exception) {
                _error.value = e.message.toString()
            }
        }
    }

}

