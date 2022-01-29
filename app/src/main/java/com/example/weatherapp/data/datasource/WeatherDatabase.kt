package com.example.weatherapp.data.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.weatherapp.data.datasource.model.RoomReport
import com.example.weatherapp.data.datasource.model.RoomWeatherData

@Database(entities = [RoomWeatherData::class,RoomReport::class], version = 1)
abstract class WeatherDatabase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDAO
}