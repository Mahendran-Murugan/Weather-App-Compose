package com.example.weatherappcleanarchitecture.presentation

import com.example.weatherappcleanarchitecture.domain.weather.WeatherInfo

data class WeatherState(
    val weatherInfo: WeatherInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
