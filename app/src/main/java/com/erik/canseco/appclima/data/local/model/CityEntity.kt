package com.erik.canseco.appclima.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "city_table")
data class CityEntity(
    @PrimaryKey
    val id: Long,
    val name: String,
    val country: String,
    val lon: Double,
    val lat: Double
)
