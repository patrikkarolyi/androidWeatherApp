package com.example.weatherapp.data.interactor

import android.content.Context
import android.widget.Toast
import com.example.weatherapp.data.datasource.DiskDataSource
import com.example.weatherapp.data.domain.toRoomReports
import com.example.weatherapp.data.domain.toRoomWeatherData
import com.example.weatherapp.data.domain.toWeatherDataViewModel
import com.example.weatherapp.data.network.NetworkDataSource
import com.example.weatherapp.data.network.util.NetworkHttpError
import com.example.weatherapp.data.network.util.NetworkIOError
import com.example.weatherapp.data.network.util.NetworkResult
import com.example.weatherapp.data.network.util.NetworkUnavailable
import com.example.weatherapp.ui.model.WeatherDataViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WeatherInteractor @Inject constructor(
    private val diskDataSource: DiskDataSource,
    private val networkDataSource: NetworkDataSource,
    private val context: Context
) {

    suspend fun getNetworkWeatherOf(city: String): List<WeatherDataViewModel> = withContext(Dispatchers.IO) {
        when (val weather = networkDataSource.getWeatherByCity(city)) {
            is NetworkResult -> {
                diskDataSource.insertWeatherData(weather.result.toRoomWeatherData())
                diskDataSource.insertReport(weather.result.toRoomReports()) }

            is NetworkUnavailable -> Toast.makeText(context, "Network is unavailable.", Toast.LENGTH_SHORT).show()

            is NetworkIOError -> Toast.makeText(context, "Network IO error.", Toast.LENGTH_SHORT).show()

            is NetworkHttpError -> Toast.makeText(context, "Network HTTP error: ${weather.errorCode}.", Toast.LENGTH_SHORT).show()
        }
        diskDataSource.getAllWeatherData().map { it.toWeatherDataViewModel() }.sortedBy { it.timestamp }
    }

    suspend fun getAllWeathers(): List<WeatherDataViewModel> = withContext(Dispatchers.IO) {
        diskDataSource.getAllWeatherData().map { it.toWeatherDataViewModel() }.sortedBy { it.timestamp }
    }

    suspend fun getWeatherById(id: Int): WeatherDataViewModel = withContext(Dispatchers.IO) {
        diskDataSource.getWeatherDataById(id).toWeatherDataViewModel()
    }
}