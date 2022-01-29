package com.example.weatherapp.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.weatherapp.R
import com.example.weatherapp.databinding.DetailsFragmentBinding
import com.example.weatherapp.databinding.ListFragmentBinding
import com.example.weatherapp.ui.list.ListViewModel
import com.example.weatherapp.ui.model.ReportViewModel
import com.example.weatherapp.ui.model.WeatherDataViewModel
import com.example.weatherapp.util.dateformatter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.list_fragment.*
import java.util.*

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private lateinit var viewModel: DetailsViewModel
    private lateinit var binding: DetailsFragmentBinding
    private val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DetailsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[DetailsViewModel::class.java]
        viewModel.weather.observe(viewLifecycleOwner, { weather ->
            setContent(weather)
        })
        viewModel.getWeatherById(args.weatherId)
    }

    private fun setContent(weather: WeatherDataViewModel) {
        val lat = "Latitude: ${weather.lat}"
        val lon = "Longitude: ${weather.lon}"
        val base = "Info comming from: ${weather.base}"
        val tempRange = if (weather.main_temp_min != weather.main_temp_max) "(${weather.main_temp_min}C° - ${weather.main_temp_max}C°)" else ""
        val temp = "Temperature: ${weather.main_temp}C° $tempRange"
        val tempFeelsLike = "Overall feels like: ${weather.main_feels_like}C°"
        val pressure = "Pressure: ${weather.main_pressure}"
        val humidity = "Humidity: ${weather.main_humidity}"
        val visibility = "Visibility: ${weather.visibility}"
        val wind = "Windiness: ${weather.wind_speed}Km/h (${weather.wind_deg}°)"
        val cloud = "Cloudiness: ${weather.cloudPercent}%"
        val dt = "DT: ${weather.dt}"
        val country = "Country: ${weather.sys_country}"
        val sunrise = "Sunrise: ${dateformatter.format(Date(weather.sys_sunrise))}"
        val sunset = "Sunset: ${dateformatter.format(Date(weather.sys_sunset))}"
        val cod = "COD: ${weather.cod}"
        val timezone = "Time zone: +${weather.timezone/3600}hour(s)"
        val dateTime = dateformatter.format(Date(weather.timestamp))
        val timestamp = "Last time checked: $dateTime"
        val report = StringBuilder().apply {
            append("Report:")
            for (report in weather.reports) {
                append(" ${report.description}")
            }
        }.toString()

        binding.name.text = weather.name
        binding.lat.text = lat
        binding.lon.text = lon
        binding.base.text = base
        binding.mainTemp.text = temp
        binding.mainFeelsLike.text = tempFeelsLike
        binding.mainPressure.text = pressure
        binding.mainHumidity.text = humidity
        binding.visibility.text = visibility
        binding.wind.text = wind
        binding.cloud.text = cloud
        binding.dt.text = dt
        binding.country.text = country
        binding.sunrise.text = sunrise
        binding.sunset.text = sunset
        binding.cod.text = cod
        binding.timezone.text = timezone
        binding.timestamp.text = timestamp
        binding.report.text = report
    }
}