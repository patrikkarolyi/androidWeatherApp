package com.example.weatherapp.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkResponse(
    val page: Int,
    val total_results: Int,
    val total_pages: Int,
    val results: List<String>
)