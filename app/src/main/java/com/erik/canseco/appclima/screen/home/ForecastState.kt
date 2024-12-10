package com.erik.canseco.appclima.screen.home

import com.erik.canseco.appclima.data.remote.response.ForecastDto

data class ForecastState(
    val isLoading: Boolean = false,
    val forecast: ForecastDto? = null,
    val error: String = "",
    val lat: Double = 0.0,
    val lon: Double = 0.0
)
