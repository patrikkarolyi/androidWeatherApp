package com.example.weatherapp.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.data.network.model.WeatherData
import com.example.weatherapp.databinding.WeatherItemBinding

class WeatherListAdapter(val listener: Listener) : ListAdapter<WeatherData, WeatherListAdapter.ViewHolder>(WeatherDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = WeatherItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: WeatherItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: WeatherData) {
            val name = "City: ${item.name}"
            val tempRange = if(item.main.temp_min != item.main.temp_max) "(${item.main.temp_min}C - ${item.main.temp_max}C)" else ""
            val temp = "Temperature: ${item.main.temp}C $tempRange"
            val wind = "Windiness: ${item.wind.speed}Km/h (${item.wind.deg} deg)"
            val cloud = "Cloudiness: ${item.clouds.all}something"

            binding.name.text = name
            binding.temp.text = temp
            binding.wind.text = wind
            binding.cloud.text = cloud
            binding.root.setOnClickListener {
                listener.onItemSelected(item.id)
            }
        }
    }

    interface Listener {
        fun onItemSelected(id: Int)
    }
}