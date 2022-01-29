package com.example.weatherapp.ui.list

import androidx.recyclerview.widget.DiffUtil
import com.example.weatherapp.data.datasource.model.RoomWeatherData
import com.example.weatherapp.data.network.model.WeatherData

class WeatherDiffUtil : DiffUtil.ItemCallback<RoomWeatherData>() {
    override fun areItemsTheSame(oldItem: RoomWeatherData, newItem: RoomWeatherData): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: RoomWeatherData, newItem: RoomWeatherData): Boolean {
        return oldItem == newItem
    }
}