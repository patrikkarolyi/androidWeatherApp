package com.example.weatherapp.ui.list

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.databinding.WeatherItemBinding
import com.example.weatherapp.ui.model.WeatherDataViewModel
import java.lang.StringBuilder
import java.text.SimpleDateFormat
import java.util.*

class WeatherListAdapter(val listener: Listener) : ListAdapter<WeatherDataViewModel, WeatherListAdapter.ViewHolder>(WeatherDiffUtil()) {

    val formatter = SimpleDateFormat("yyyy.MM.dd HH:mm:ss",Locale.getDefault());

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = WeatherItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: WeatherItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: WeatherDataViewModel) {
            val name = "City: ${item.name}"
            val tempRange = if (item.main_temp_min != item.main_temp_max) "(${item.main_temp_min}C° - ${item.main_temp_max}C°)" else ""
            val temp = "Temperature: ${item.main_temp}C° $tempRange"
            val wind = "Windiness: ${item.wind_speed}Km/h (${item.wind_deg}°)"
            val cloud = "Cloudiness: ${item.cloudPercent}%"
            val dateTime = formatter.format(Date(item.timestamp))

            val report = StringBuilder().apply {
                append("Report:")
                for(report in item.reports){
                    append(" ${report.description}")
                }
            }.toString()

            binding.name.text = name
            binding.temp.text = temp
            binding.wind.text = wind
            binding.cloud.text = cloud
            binding.report.text = report
            binding.datetime.text = dateTime
            binding.root.setOnClickListener {
                listener.onItemSelected(item.id)
            }
        }
    }

    interface Listener {
        fun onItemSelected(id: Int)
    }
}