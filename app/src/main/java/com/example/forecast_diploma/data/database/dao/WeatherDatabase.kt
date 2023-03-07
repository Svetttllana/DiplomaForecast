package com.example.forecast_diploma.data.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.forecast_diploma.data.database.WeatherEntity

@Database(entities = [WeatherEntity::class], version = 1, exportSchema = false)
abstract class WeatherDatabase: RoomDatabase() {

    abstract fun getWeatherDAO():WeatherDAO

    companion object{

        private const val DATABASE_NAME = "DATABASE_NAME"
        private var DB_INSTANCE:WeatherDatabase? = null

        fun getWeatherDatabaseInstance(context: Context):WeatherDatabase{

            return DB_INSTANCE ?: Room
                .databaseBuilder(
                    context.applicationContext,
                    WeatherDatabase::class.java,
                    DATABASE_NAME
                )
                .build()
                .also { DB_INSTANCE = it }

        }

    }
}