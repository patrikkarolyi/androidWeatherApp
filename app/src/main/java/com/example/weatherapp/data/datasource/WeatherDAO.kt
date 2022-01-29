package com.example.weatherapp.data.datasource

import androidx.room.*
import com.example.weatherapp.data.datasource.model.RoomWeatherData
import com.example.weatherapp.data.datasource.model.WeatherDataWithReports

@Dao
interface WeatherDAO {

    @Transaction
    @Query("SELECT * FROM weathers")
    fun getAllWeathersAndReports(): List<WeatherDataWithReports>

    @Transaction
    @Query("SELECT * FROM weathers WHERE id = :id")
    abstract fun getWeathersAndReportsById(id: Int): WeatherDataWithReports

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertWeather(weather: RoomWeatherData)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertWeathers(weathers: List<RoomWeatherData>)
}