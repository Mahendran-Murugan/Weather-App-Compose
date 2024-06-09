package com.example.weatherappcleanarchitecture.data.repositiory

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.weatherappcleanarchitecture.data.mappers.toWeatherInfo
import com.example.weatherappcleanarchitecture.data.remote.WeatherAPI
import com.example.weatherappcleanarchitecture.domain.repository.WeatherRepository
import com.example.weatherappcleanarchitecture.domain.util.Resource
import com.example.weatherappcleanarchitecture.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImplementation @Inject constructor(
    private val api: WeatherAPI
): WeatherRepository {
    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getWeatherData(
        latitude: Double,
        longitude: Double
    ): Resource<WeatherInfo> {
        return try{
            Resource.Success(
                data = api.getWeatherInfo(
                    latitude = latitude,
                    longitude = longitude
                ).toWeatherInfo()
            )
        }catch(e: Exception){
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}