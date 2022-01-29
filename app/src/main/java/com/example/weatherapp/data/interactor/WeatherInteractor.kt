package com.example.weatherapp.data.interactor

import android.content.Context
import android.widget.Toast
import com.example.weatherapp.data.datasource.DiskDataSource
import com.example.weatherapp.data.datasource.model.RoomWeatherData
import com.example.weatherapp.data.domain.toRoomWeatherData
import com.example.weatherapp.data.network.NetworkDataSource
import com.example.weatherapp.data.network.util.NetworkHttpError
import com.example.weatherapp.data.network.util.NetworkIOError
import com.example.weatherapp.data.network.util.NetworkResult
import com.example.weatherapp.data.network.util.NetworkUnavailable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WeatherInteractor @Inject constructor(
    private val diskDataSource: DiskDataSource,
    private val networkDataSource: NetworkDataSource,
    private val context: Context
) {

    suspend fun getNetworkWeatherOf(city: String): List<RoomWeatherData> = withContext(Dispatchers.IO) {
        when (val weather = networkDataSource.getWeatherByCity(city)) {
            is NetworkResult -> {
                val roomWeatherData = weather.result.toRoomWeatherData()
                diskDataSource.insertWeatherData(roomWeatherData)
                diskDataSource.getAllWeatherData()
            }
            is NetworkUnavailable -> {
                Toast.makeText(context, "Network is unavailable.", Toast.LENGTH_SHORT).show()
                listOf()
            }
            is NetworkIOError -> {
                Toast.makeText(context, "Network IO error.", Toast.LENGTH_SHORT).show()
                listOf()
            }
            is NetworkHttpError -> {
                Toast.makeText(context, "Network HTTP error: ${weather.errorCode}.", Toast.LENGTH_SHORT).show()
                listOf()
            }
        }
    }

    suspend fun getAllWeathers(): List<RoomWeatherData> = withContext(Dispatchers.IO) {
        diskDataSource.getAllWeatherData()
    }
}