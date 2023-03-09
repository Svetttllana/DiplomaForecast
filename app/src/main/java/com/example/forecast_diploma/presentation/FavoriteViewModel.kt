package com.example.forecast_diploma.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.forecast_diploma.domain.WeatherInteractor
import com.example.forecast_diploma.presentation.model.FavoriteModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val weatherInteractor: WeatherInteractor
) : ViewModel() {

    private val _favorite = MutableLiveData<List<FavoriteModel>>()
    val favorite = _favorite

    fun getWeatherFavorites() {
        viewModelScope.launch {
            try {
                val favorite = weatherInteractor.getFavorite()
                favorite.collect {
                    _favorite.value = it
                }
            } catch (e: Exception) {
                Log.w("Fav Error", e.toString())
            }
        }
    }


    fun deleteFav(name: String) {
        viewModelScope.launch {
            try {
                weatherInteractor.deliteFavByName(name)
            } catch (e: Exception) {
                Log.w("deleteFav", e.message.toString())
            }
        }
    }


}