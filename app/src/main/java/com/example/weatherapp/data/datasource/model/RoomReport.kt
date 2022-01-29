package com.example.weatherapp.data.datasource.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Reports")
data class RoomReport(
    @PrimaryKey
    val id: Int,
    val weatherId: Int,
    val main: String,
    val description: String,
    val icon: String,
)