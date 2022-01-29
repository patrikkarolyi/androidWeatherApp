package com.example.weatherapp.data.datasource

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DiskModule {

    companion object {
        private const val DB_NAME = "weather-db"
    }

    @Provides
    fun provideWeatherDao(db: WeatherDatabase): WeatherDAO = db.weatherDao()

    @Provides
    fun provideApplicationContext(@ApplicationContext context: Context): Context = context

    @Provides
    fun provideWeatherDatabase(context: Context): WeatherDatabase {
        return Room.databaseBuilder(context, WeatherDatabase::class.java, DB_NAME).build()
    }
}