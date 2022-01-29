package com.example.weatherapp.ui.list

import androidx.recyclerview.widget.DiffUtil
import com.example.weatherapp.data.datasource.model.RoomWeatherData
import com.example.weatherapp.data.network.model.WeatherData
import com.example.weatherapp.ui.model.WeatherDataViewModel

class WeatherDiffUtil : DiffUtil.ItemCallback<WeatherDataViewModel>() {
    override fun areItemsTheSame(oldItem: WeatherDataViewModel, newItem: WeatherDataViewModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: WeatherDataViewModel, newItem: WeatherDataViewModel): Boolean {
        return oldItem == newItem
    }
}