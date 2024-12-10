package com.erik.canseco.appclima.domain.repository

import com.erik.canseco.appclima.data.remote.response.ForecastDto
import com.erik.canseco.appclima.util.Resource
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    suspend fun getWeather(lat: Double, lon: Double):Flow<Resource<ForecastDto>>
}