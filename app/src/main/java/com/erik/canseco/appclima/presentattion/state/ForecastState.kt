package com.erik.canseco.appclima.presentattion.state

import com.erik.canseco.appclima.domain.model.WeatherData

data class ForecastState(
    val isLoading: Boolean = false,
    val forecast: List<WeatherData>? = null,
    val error: String = "",
    val lat: Double = 0.0,
    val lon: Double = 0.0
)
