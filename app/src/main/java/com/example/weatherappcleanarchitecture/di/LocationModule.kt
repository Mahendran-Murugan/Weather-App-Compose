package com.example.weatherappcleanarchitecture.di

import com.example.weatherappcleanarchitecture.data.location.DefaultLocationTracker
import com.example.weatherappcleanarchitecture.domain.location.LocationTracker
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import javax.inject.Singleton

@Module
@InstallIn(Singleton::class)
abstract class LocationModule {
    @Binds
    @Singleton
    abstract fun bindLocationTracker(defaultLocationTracker: DefaultLocationTracker):LocationTracker
}