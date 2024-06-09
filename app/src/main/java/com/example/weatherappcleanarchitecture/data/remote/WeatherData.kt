package com.example.weatherappcleanarchitecture.data.remote

import com.squareup.moshi.Json

data class WeatherData(
    @field: Json(name = "hourly")
    val weatherData: WeatherDataDto
)
