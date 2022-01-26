package com.example.weatherapp.data.interactor

import com.example.weatherapp.data.network.NetworkDataSource
import com.example.weatherapp.data.network.model.WeatherData
import javax.inject.Inject

class WeatherInteractor @Inject constructor(
    private val networkDataSource: NetworkDataSource
) {

    suspend fun getWeatherOf(city: String): WeatherData? {
        return networkDataSource.getWeatherByCity(city)
    }
}