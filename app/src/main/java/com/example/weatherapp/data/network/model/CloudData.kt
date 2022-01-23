package com.example.weatherapp.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CloudData(
    val all: Int
)
