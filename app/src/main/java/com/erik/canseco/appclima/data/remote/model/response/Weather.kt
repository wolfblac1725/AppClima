package com.erik.canseco.appclima.data.remote.model.response

data class Weather(
    val id: Long,
    val main: String,
    val description: String,
    val icon: String
)