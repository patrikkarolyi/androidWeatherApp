package com.example.weatherapp.data.network

import com.example.weatherapp.data.network.model.WeatherData
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {

    companion object {
        const val baseUrl = "https://api.openweathermap.org/"
        const val API_KEY = "f397c659323666d3a70df7e69eb4a7b3"
    }

    @GET("data/2.5/weather/")
    suspend fun getWeatherDataOfCity(
        @Query("appid") apiKey: String,
        @Query("q") city: String,
        @Query("units") unit: String,
    ): WeatherData

}