package com.erik.canseco.appclima.data.remote.response

data class City(
    val id: Long,
    val name: String,
    val coord: Coord,
    val country: String,
    val population: Long,
    val timezone: Long
)