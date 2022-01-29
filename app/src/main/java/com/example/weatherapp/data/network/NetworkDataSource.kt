package com.example.weatherapp.data.network

import android.content.Context
import com.example.weatherapp.data.network.model.WeatherData
import com.example.weatherapp.data.network.util.NetworkResponse
import com.example.weatherapp.data.network.util.executeNetworkCall
import javax.inject.Inject

class NetworkDataSource @Inject constructor(
    private val weatherAPI: WeatherAPI,
    private val  context: Context
) {

    suspend fun getWeatherByCity( city: String ): NetworkResponse<WeatherData> =
        executeNetworkCall(context) {
            weatherAPI.getWeatherDataOfCity(
                apiKey = WeatherAPI.API_KEY,
                city = city,
                unit = "metric"
            )
        }

}