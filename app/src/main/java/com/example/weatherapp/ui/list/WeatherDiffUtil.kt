package com.example.weatherapp.ui.list

import androidx.recyclerview.widget.DiffUtil
import com.example.weatherapp.data.network.model.WeatherData

class WeatherDiffUtil : DiffUtil.ItemCallback<WeatherData>() {
    override fun areItemsTheSame(oldItem: WeatherData, newItem: WeatherData): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: WeatherData, newItem: WeatherData): Boolean {
        return oldItem == newItem
    }
}