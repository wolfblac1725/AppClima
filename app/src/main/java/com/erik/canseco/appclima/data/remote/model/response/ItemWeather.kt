package com.erik.canseco.appclima.data.remote.model.response

import com.erik.canseco.appclima.data.local.model.WeatherEntity
import com.google.gson.annotations.SerializedName

data class ItemWeather(
    val dt: Long,
    val sunrise: Long,
    val sunset: Long,
    val temp: Temp,
    @SerializedName("feels_like")
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

fun ItemWeather.toWeatherEntity(
    id_city: Int
): WeatherEntity {
    return WeatherEntity(
        dt = dt,
        idCity = id_city,
        tempDay = temp.day,
        tempNight = temp.night,
        tempMax = temp.max,
        tempMin = temp.min,
        tempEve = temp.eve,
        tempMorn = temp.morn,
        humidity = humidity,
        pressure = pressure,
        speed = speed,
        weatherMain = weather[0].main ,
        weatherDescription = weather[0].description,
        weatherIcon = weather[0].icon,
        rain = rain
    )
}