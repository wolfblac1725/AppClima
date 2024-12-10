package com.erik.canseco.appclima.data.remote.response

data class Weather(
    val id: Long,
    val main: String,
    val description: String,
    val icon: String
)