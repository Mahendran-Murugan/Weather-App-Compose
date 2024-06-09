package com.example.weatherappcleanarchitecture.domain.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {

    @GET("v1/forecast?hourly=temperature_2m,relativehumidity_2m,weathercode,windspeed_10m,pressure_msl")
    suspend fun getWeatherInfo(
        @Query("latitude") latitude : Double,
        @Query("longitude") longitude : Double,
    ): WeatherData
}