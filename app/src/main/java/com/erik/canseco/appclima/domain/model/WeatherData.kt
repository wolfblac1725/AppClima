package com.erik.canseco.appclima.domain.model

import com.erik.canseco.appclima.data.local.model.WeatherEntity
import com.erik.canseco.appclima.data.remote.model.response.ItemWeather


data class WeatherData(
    val dt: Long,
    val name: String,
    val country: String,
    val lon: Double,
    val lat: Double,
    val tempDay: Double,
    val tempNight: Double,
    val tempMax: Double,
    val tempMin: Double,
    val tempEve: Double,
    val tempMorn: Double,
    val humidity: Long,
    val pressure: Long,
    val speed: Double,
    val weatherMain: String,
    val weatherDescription: String,
    val weatherIcon: String,
    val rain: Double?,
)
fun WeatherEntity.toWeatherData(
    name: String,
    country: String,
    lon: Double,
    lat: Double
): WeatherData {
    return WeatherData(
        dt = dt,
        name = name,
        country = country,
        lon = lon,
        lat = lat,
        tempDay = tempDay,
        tempNight = tempNight,
        tempMax = tempMax,
        tempMin = tempMin,
        tempEve = tempEve,
        tempMorn = tempMorn,
        humidity = humidity,
        pressure = pressure,
        speed = speed,
        weatherMain = weatherMain,
        weatherDescription = weatherDescription,
        weatherIcon = weatherIcon,
        rain = rain
    )
}
 fun ItemWeather.toWeatherData(
     name: String,
     country: String,
     lon: Double,
     lat: Double
 ): WeatherData {
     return WeatherData(
     dt = dt,
     name = name,
     country = country,
     lon = lon,
     lat = lat,
     tempDay = temp.day,
     tempNight = temp.night,
     tempMax = temp.max,
     tempMin = temp.min,
     tempEve = temp.eve,
     tempMorn = temp.morn,
     humidity = humidity,
     pressure = pressure,
     speed = speed,
     weatherMain= weather[0].main,
     weatherDescription= weather[0].description,
     weatherIcon= weather[0].icon,
     rain = rain
     )
}
