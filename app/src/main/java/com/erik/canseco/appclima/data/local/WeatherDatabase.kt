package com.erik.canseco.appclima.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.erik.canseco.appclima.data.local.model.CityEntity
import com.erik.canseco.appclima.data.local.model.WeatherEntity

@Database(entities = [WeatherEntity::class, CityEntity::class], version = 1)
abstract class WeatherDatabase : RoomDatabase() {
    abstract val weatherDao: WeatherDao
}