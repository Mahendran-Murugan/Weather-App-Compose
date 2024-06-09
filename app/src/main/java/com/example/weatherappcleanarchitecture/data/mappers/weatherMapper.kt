package com.example.weatherappcleanarchitecture.data.mappers

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.weatherappcleanarchitecture.data.remote.WeatherData
import com.example.weatherappcleanarchitecture.data.remote.WeatherDataDto
import com.example.weatherappcleanarchitecture.domain.weather.WeatherDataDomain
import com.example.weatherappcleanarchitecture.domain.weather.WeatherInfo
import com.example.weatherappcleanarchitecture.domain.weather.WeatherType
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
fun WeatherDataDto.toWeatherDataMap(): Map<Int, List<WeatherDataDomain>>{
    return timeList.mapIndexed{ index, time ->
        val temperature = temperatureList[index]
        val weatherCode = weatherCodeList[index]
        val windSpeed = windSpeedList[index]
        val pressure = pressureList[index]
        val humidity = humidityList[index]

        WeatherDataDomain(
            time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
            tempCelsius = temperature,
            pressure = pressure,
            windSpeed = windSpeed,
            humidity = humidity,
            weatherType = WeatherType.fromWMO(index)
        )
    }.groupBy {
        it.time.dayOfMonth
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun WeatherData.toWeatherInfo(): WeatherInfo {
    val weatherDataMap = weatherData.toWeatherDataMap()
    val now = LocalDateTime.now()
    val currWeatherData = weatherDataMap[0]?.find{
        val hour = if(now.minute < 30) now.hour else now.hour + 1
        it.time.hour == hour
    }
    return WeatherInfo(
        weatherDataOfDay = weatherDataMap,
        currWeatherData = currWeatherData
    )
}
