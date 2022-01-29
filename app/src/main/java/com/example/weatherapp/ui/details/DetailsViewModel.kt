package com.example.weatherapp.ui.details

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
class DetailsViewModel @Inject constructor(
    private val weatherInteractor: WeatherInteractor
) : ViewModel() {

    private val scope: CoroutineScope = CoroutineScope(Dispatchers.Main)
    private var job: Job? = null
    val weather = MutableLiveData<WeatherDataViewModel>()

    fun getWeatherById(id: Int) {
        job?.cancel()
        job = scope.launch {
            val data = weatherInteractor.getWeatherById(id)
            weather.value = data
            ///TODO error handling
        }
    }
}