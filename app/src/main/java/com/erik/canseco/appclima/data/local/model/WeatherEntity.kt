package com.erik.canseco.appclima.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "weather_table", primaryKeys = ["dt", "idCity"])
data class WeatherEntity(
    val dt: Long,
    val idCity: Int,
    @ColumnInfo(name = "day")
    val tempDay: Double,
    @ColumnInfo(name = "night")
    val tempNight: Double,
    @ColumnInfo(name = "max")
    val tempMax: Double,
    @ColumnInfo(name = "min")
    val tempMin: Double,
    @ColumnInfo(name = "eve")
    val tempEve: Double,
    @ColumnInfo(name = "morn")
    val tempMorn: Double,
    val humidity: Long,
    val pressure: Long,
    val speed: Double,
    @ColumnInfo(name = "main")
    val weatherMain: String,
    @ColumnInfo(name = "description")
    val weatherDescription: String,
    @ColumnInfo(name = "icon")
    val weatherIcon: String,
    val rain: Double? = null,
)
