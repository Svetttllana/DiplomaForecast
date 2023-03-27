package com.example.forecast_diploma.data.sharedprefs

import android.content.SharedPreferences
import javax.inject.Inject

class SharedPreferencesHelper @Inject constructor(
    private val sharedPreferences: SharedPreferences
) {
   suspend fun saveBlackTheme(){
        return sharedPreferences.edit().putBoolean(DARK_THEME_SAVE, true).apply()
    }


    fun checkTeme(isCheckd:Boolean){
        sharedPreferences.edit().putBoolean(DARK_THEME_SAVE,isCheckd).apply()
    }

    companion object {
        private const val DARK_THEME_SAVE = "Dark teme save"
    }
}