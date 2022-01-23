package com.example.weatherapp.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Report(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String,
)
