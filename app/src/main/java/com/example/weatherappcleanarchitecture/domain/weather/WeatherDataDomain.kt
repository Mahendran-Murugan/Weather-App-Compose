package com.example.weatherappcleanarchitecture.domain.weather

import java.time.LocalDateTime

data class WeatherDataDomain(
    val time: LocalDateTime,
    val tempCelsius: Double,
    val pressure: Double,
    val windSpeed: Double,
    val humidity: Double,
    val weatherType: WeatherType
)