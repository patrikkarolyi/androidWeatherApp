package com.example.weatherapp.data.datasource

import com.example.weatherapp.data.datasource.model.RoomWeatherData
import javax.inject.Inject

class DiskDataSource @Inject constructor(
    private val weatherDao: WeatherDAO
) {

    fun getAllWeatherData(): List<RoomWeatherData> {
        return weatherDao.getAllWeathersAndReports().map {
            it.roomWeatherData}
    }

    fun insertWeatherData(data: RoomWeatherData) {
        return weatherDao.insertWeather(data)
    }

}