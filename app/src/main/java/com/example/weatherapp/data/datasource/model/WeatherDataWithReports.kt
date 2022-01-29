package com.example.weatherapp.data.datasource.model


import androidx.room.Embedded
import androidx.room.Relation


data class WeatherDataWithReports(
    @Embedded val roomWeatherData: RoomWeatherData,
    @Relation(
        parentColumn = "id",
        entityColumn = "weatherId",
        entity = RoomReport::class
    )
    val reports: List<RoomReport>
)