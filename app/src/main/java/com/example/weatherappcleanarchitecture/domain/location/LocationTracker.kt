package com.example.weatherappcleanarchitecture.domain.location

import android.location.Location

interface LocationTracker {

    suspend fun getCurrentLocation(): Location?

}