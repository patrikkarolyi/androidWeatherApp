package com.example.weatherapp.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WindData(
    val speed: Double,
    val deg: Int
)
