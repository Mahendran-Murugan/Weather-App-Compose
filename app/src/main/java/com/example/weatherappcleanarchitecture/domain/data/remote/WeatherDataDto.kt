package com.example.weatherappcleanarchitecture.domain.data.remote

import com.squareup.moshi.Json

data class WeatherDataDto (
    val timeList: List<String>,
    @field: Json(name = "temperature_2m")
    val temperatureList: List<Double>,
    @field: Json(name = "weathercode")
    val weatherCodeList: List<Double>,
    @field: Json(name = "windspeed_10m")
    val windSpeedList: List<Double>,
    @field: Json(name = "humidity")
    val humidityList: List<Double>,
)