package com.erik.canseco.appclima.data.remote.model.response

data class ForecastDto(
    val city: City,
    val cod: String,
    val message: Double,
    val cnt: Long,
    val list: List<ItemWeather>
)