package com.erik.canseco.appclima.domain.repository

import com.erik.canseco.appclima.domain.model.WeatherData
import com.erik.canseco.appclima.util.Resource
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    suspend fun getWeather(lat: Double, lon: Double):Flow<Resource<List<WeatherData>>>
}