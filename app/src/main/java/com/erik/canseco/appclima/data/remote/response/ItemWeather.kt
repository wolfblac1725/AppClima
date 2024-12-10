package com.erik.canseco.appclima.data.remote.response

data class ItemWeather(
    val dt: Long,
    val sunrise: Long,
    val sunset: Long,
    val temp: Temp,
    val feelsLike: FeelsLike,
    val pressure: Long,
    val humidity: Long,
    val weather: List<Weather>,
    val speed: Double,
    val deg: Long,
    val gust: Double,
    val clouds: Long,
    val pop: Double,
    val rain: Double? = null
)