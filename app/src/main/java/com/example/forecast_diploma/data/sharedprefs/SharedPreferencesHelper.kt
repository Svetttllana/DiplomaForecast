package com.example.forecast_diploma.data.sharedprefs

import android.content.SharedPreferences
import javax.inject.Inject

class SharedPreferencesHelper @Inject constructor(
    private val sharedPreferences: SharedPreferences
) {
    fun saveBlackTheme(isSave: Boolean) {
        sharedPreferences.edit().putBoolean(DARK_THEME_SAVE, isSave).apply()
    }
    companion object {
        private const val DARK_THEME_SAVE = "Dark teme save"

    }

}