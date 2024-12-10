package com.erik.canseco.appclima.data.remote

import com.erik.canseco.appclima.data.remote.response.ForecastDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("forecast/daily")
    suspend fun getForecastQuery(
        @Query("q") q : String,
    ): ForecastDto

    @GET("forecast/daily")
    suspend fun getForecastLatLon(
        @Query("lat") lat : Double,
        @Query("lon") lon : Double
    ): ForecastDto

}