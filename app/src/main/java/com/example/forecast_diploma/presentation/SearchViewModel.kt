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
class SearchViewModel @Inject constructor(
    private val weatherInteractor: WeatherInteractor
): ViewModel() {

    private val _item = MutableLiveData<WeatherModel>()
    val item : LiveData<WeatherModel> = _item

    fun findItem(searchText:String){
        viewModelScope.launch {
            try {
                val foundName= weatherInteractor.findWeather(searchText)
                _item.value= foundName
            }catch (e: Exception){
                Log.w("exception", e.message.toString())
            }
        }
    }
}