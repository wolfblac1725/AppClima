package com.erik.canseco.appclima.data.remote.model.response

import com.erik.canseco.appclima.data.local.model.CityEntity

data class City(
    val id: Long,
    val name: String,
    val coord: Coord,
    val country: String,
    val population: Long,
    val timezone: Long
)
fun City.toCityEntity(): CityEntity {
    return CityEntity(
        id = id,
        name = name,
        country = country,
        lon = coord.lon,
        lat = coord.lat
    )
}