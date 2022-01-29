package com.example.weatherapp.data.datasource.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Reports")
data class RoomReport(
    val id: Int,
    @PrimaryKey
    val weatherId: Int,
    val main: String,
    val description: String,
    val icon: String,
)