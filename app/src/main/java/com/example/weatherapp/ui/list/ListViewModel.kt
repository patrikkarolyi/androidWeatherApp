package com.example.weatherapp.ui.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.data.interactor.WeatherInteractor
import com.example.weatherapp.ui.model.WeatherDataViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val weatherInteractor: WeatherInteractor
) : ViewModel() {

    private val scope: CoroutineScope = CoroutineScope(Dispatchers.Main)
    private var job: Job? = null
    val weather = MutableLiveData<List<WeatherDataViewModel>>()

    fun getWeatherOf(city: String) {
        job?.cancel()
        job = scope.launch {
            val data = weatherInteractor.getNetworkWeatherOf(city)
            weather.value = data
            ///TODO error handling
        }
    }

    fun getLocalWeathers() {
        job?.cancel()
        job = scope.launch {
            val data = weatherInteractor.getAllWeathers()
            weather.value = data
            ///TODO error handling
        }
    }
}