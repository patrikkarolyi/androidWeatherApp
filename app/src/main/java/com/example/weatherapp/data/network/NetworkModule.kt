package com.example.weatherapp.data.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(WeatherAPI.baseUrl)
        .client(OkHttpClient())
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    @Provides
    fun provideWeatherAPI(retrofit: Retrofit): WeatherAPI = retrofit.create(WeatherAPI::class.java)

}