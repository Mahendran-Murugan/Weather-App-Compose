package com.example.weatherappcleanarchitecture.di

import com.example.weatherappcleanarchitecture.data.repositiory.WeatherRepositoryImplementation
import com.example.weatherappcleanarchitecture.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import javax.inject.Singleton

@Module
@InstallIn(Singleton::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindsRepositoryModule(weatherRepositoryImplementation: WeatherRepositoryImplementation): WeatherRepository
}