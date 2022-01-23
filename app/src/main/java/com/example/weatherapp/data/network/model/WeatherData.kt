package com.example.weatherapp.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeatherData(
    val coord: Coord,
    val weather: List<Report>,
    val base: String,
    val main: MainData,
    val visibility: Int,
    val wind: WindData,
    val clouds: CloudData,
    val dt: Long,
    val sys: CountryData,
    val timezone: Int,
    val id: Int,
    val name: String,
    val cod: Int
)