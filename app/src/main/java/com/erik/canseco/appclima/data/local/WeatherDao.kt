package com.erik.canseco.appclima.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.erik.canseco.appclima.data.local.model.CityEntity
import com.erik.canseco.appclima.data.local.model.WeatherEntity

@Dao
interface WeatherDao {

    @Upsert
    suspend fun upsertCity(cityEntity: CityEntity)

    @Upsert
    suspend fun upsertWeather(weatherEntity: List<WeatherEntity>)

    @Query("SELECT * FROM weather_table WHERE dt >=:date")
    suspend fun getWeatherDate(date: Long): List<WeatherEntity>

    @Query("SELECT * FROM city_table WHERE lon=:lon AND lat=:lat")
    suspend fun getCity(lon: Double, lat: Double): List<CityEntity>

    @Query("DELETE FROM weather_table")
    suspend fun deleteWeather()

    @Query("DELETE FROM city_table")
    suspend fun deleteCity()

}