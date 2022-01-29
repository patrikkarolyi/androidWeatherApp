package com.example.weatherapp.data.domain

import com.example.weatherapp.data.datasource.model.RoomWeatherData
import com.example.weatherapp.data.network.model.WeatherData

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