package com.example.weatherapp.data.datasource.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Weathers")
data class RoomWeatherData(
    @PrimaryKey
    val id: Int,
    val lon: Double,
    val lat: Double,
    val base: String,
    val main_temp: Double,
    val main_feels_like: Double,
    val main_temp_min: Double,
    val main_temp_max: Double,
    val main_pressure: Int,
    val main_humidity: Int,
    val visibility: Int,
    val wind_speed: Double,
    val wind_deg: Int,
    val cloudPercent: Int,
    val dt: Long,
    val sys_type: Int,
    val sys_id: Int,
    val sys_country: String,
    val sys_sunrise: Long,
    val sys_sunset: Long,
    val timezone: Int,
    val name: String,
    val cod: Int,
    val timestamp: Long
)
