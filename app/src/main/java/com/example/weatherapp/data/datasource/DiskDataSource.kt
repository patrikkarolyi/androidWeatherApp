package com.example.weatherapp.data.datasource

import com.example.weatherapp.data.datasource.model.RoomReport
import com.example.weatherapp.data.datasource.model.RoomWeatherData
import com.example.weatherapp.data.datasource.model.WeatherDataWithReports
import javax.inject.Inject

class DiskDataSource @Inject constructor(
    private val weatherDao: WeatherDAO,
    private val reportDAO: ReportDAO,
) {

    fun getAllWeatherData(): List<WeatherDataWithReports> {
        return weatherDao.getAllWeathersAndReports()
    }

    fun getWeatherDataById(id: Int): WeatherDataWithReports {
        return weatherDao.getWeathersAndReportsById(id)
    }

    fun insertWeatherData(data: RoomWeatherData) {
        return weatherDao.insertWeather(data)
    }

    fun insertReport(data: List<RoomReport>) {
        return reportDAO.insertReports(data)
    }
}