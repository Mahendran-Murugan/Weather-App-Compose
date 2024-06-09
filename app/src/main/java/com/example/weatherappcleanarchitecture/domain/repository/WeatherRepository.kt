package com.example.weatherappcleanarchitecture.domain.repository

import com.example.weatherappcleanarchitecture.domain.util.Resource
import com.example.weatherappcleanarchitecture.domain.weather.WeatherInfo

interface WeatherRepository {

    suspend fun getWeatherData(latitude: Double, longitude: Double):Resource<WeatherInfo>

}