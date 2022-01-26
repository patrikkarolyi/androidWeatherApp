package com.example.weatherapp.data.network

import com.example.weatherapp.data.network.model.WeatherData
import javax.inject.Inject

class NetworkDataSource @Inject constructor(
    private val weatherAPI: WeatherAPI
) {

    companion object {
        const val baseUrl = "https://api.openweathermap.org/"
        const val API_KEY = "f397c659323666d3a70df7e69eb4a7b3"
    }

    suspend fun getWeatherByCity(
        city: String
    ): WeatherData? {
        return try{
            weatherAPI.getWeatherDataOfCity(
                apiKey = API_KEY,
                city = city,
                unit = "metric"
            )
        }catch (e: Exception){
            ///TODO error handling
            null
        }

    }
}