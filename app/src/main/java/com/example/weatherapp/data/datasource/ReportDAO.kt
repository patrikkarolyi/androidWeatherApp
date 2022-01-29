package com.example.weatherapp.data.datasource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.weatherapp.data.datasource.model.RoomReport

@Dao
interface ReportDAO {

    @Query("SELECT * FROM reports")
    fun getAllReports(): List<RoomReport>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertReports(reports: List<RoomReport>)
}