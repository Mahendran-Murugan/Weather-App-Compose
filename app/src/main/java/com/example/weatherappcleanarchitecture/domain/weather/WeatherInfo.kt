package com.example.weatherappcleanarchitecture.domain.weather

data class WeatherInfo(
    val weatherDataOfDay: Map<Int, List<WeatherDataDomain>>,
    val currWeatherData: WeatherDataDomain?
)