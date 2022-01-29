package com.example.weatherapp.data.domain

import com.example.weatherapp.data.datasource.model.RoomReport
import com.example.weatherapp.data.datasource.model.RoomWeatherData
import com.example.weatherapp.data.datasource.model.WeatherDataWithReports
import com.example.weatherapp.data.network.model.WeatherData
import com.example.weatherapp.ui.model.ReportViewModel
import com.example.weatherapp.ui.model.WeatherDataViewModel

fun WeatherData.toRoomWeatherData(): RoomWeatherData {
    return RoomWeatherData(
        id = id,
        lon = coord.lon,
        lat = coord.lat,
        base = base,
        main_temp = main.temp,
        main_feels_like = main.feels_like,
        main_temp_min = main.temp_min,
        main_temp_max = main.temp_max,
        main_pressure = main.pressure,
        main_humidity = main.humidity,
        visibility = visibility,
        wind_speed = wind.speed,
        wind_deg = wind.deg,
        cloudPercent = clouds.all,
        dt = dt,
        sys_type = sys.type,
        sys_id = sys.id,
        sys_country = sys.country,
        sys_sunrise = sys.sunrise,
        sys_sunset = sys.sunset,
        timezone = timezone,
        name = name,
        cod = cod,
        timestamp = timestamp,
    )
}

fun WeatherData.toRoomReports(): List<RoomReport> {
    return weather.map {
        RoomReport(
            id = it.id,
            weatherId = id,
            main = it.main,
            description = it.description,
            icon = it.icon
        )
    }
}

fun WeatherDataWithReports.toWeatherDataViewModel(): WeatherDataViewModel {
    return WeatherDataViewModel(
        id = roomWeatherData.id,
        lon = roomWeatherData.lon,
        lat = roomWeatherData.lat,
        base = roomWeatherData.base,
        main_temp = roomWeatherData.main_temp,
        main_feels_like = roomWeatherData.main_feels_like,
        main_temp_min = roomWeatherData.main_temp_min,
        main_temp_max = roomWeatherData.main_temp_max,
        main_pressure = roomWeatherData.main_pressure,
        main_humidity = roomWeatherData.main_humidity,
        visibility = roomWeatherData.visibility,
        wind_speed = roomWeatherData.wind_speed,
        wind_deg = roomWeatherData.wind_deg,
        cloudPercent = roomWeatherData.cloudPercent,
        dt = roomWeatherData.dt,
        sys_type = roomWeatherData.sys_type,
        sys_id = roomWeatherData.sys_id,
        sys_country = roomWeatherData.sys_country,
        sys_sunrise = roomWeatherData.sys_sunrise,
        sys_sunset = roomWeatherData.sys_sunset,
        timezone = roomWeatherData.timezone,
        name = roomWeatherData.name,
        cod = roomWeatherData.cod,
        timestamp = roomWeatherData.timestamp,
        reports = reports.map {
            ReportViewModel(
                id = it.id,
                main = it.main,
                description = it.description,
                icon = it.icon
            )
        }
    )
}