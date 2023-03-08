package com.example.forecast_diploma.presentation

import androidx.lifecycle.ViewModel
import com.example.forecast_diploma.domain.WeatherInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

//@HiltViewModel
//class SearchViewModel @Inject constructor(
//    private val weatherInteractor: WeatherInteractor
//): ViewModel() {
//
//    private val _item = MutableLiveData<WeatherModel>()
//    val item : LiveData<WeatherModel> = _item
//
//
//
////    fun findItem(searchText:String){
////        viewModelScope.launch {
////            try {
////                val foundItem = weatherInteractor.findItem(searchText)
////                _item.value= foundItem
////            }catch (e: Exception){
////                Log.w("exception", e.message.toString())
////            }
////
////        }
////
////    }
//}