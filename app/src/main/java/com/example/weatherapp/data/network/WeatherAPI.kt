package com.example.weatherapp.data.network

import com.example.weatherapp.data.network.model.WeatherData
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {

    @GET("data/2.5/weather/")
    suspend fun getWeatherDataOfCity(
        @Query("appid") apiKey: String,
        @Query("q") city: String,
        @Query("units") unit: String,
    ): WeatherData

}