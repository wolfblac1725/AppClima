package com.erik.canseco.appclima.data.repository

import android.util.Log
import com.erik.canseco.appclima.data.remote.WeatherApi
import com.erik.canseco.appclima.data.remote.response.ForecastDto
import com.erik.canseco.appclima.domain.repository.WeatherRepository
import com.erik.canseco.appclima.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
): WeatherRepository {
    override suspend fun getWeather(lat: Double, lon: Double): Flow<Resource<ForecastDto>> {
        return flow {
            emit(Resource.Loading(true))
            val forecast = try {
                api.getForecastLatLon(lat, lon)
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error("No se pudo cargar los datos"))
                return@flow
            } catch (e: HttpException) {
                emit(Resource.Error("No se pudo cargar los datos"))
                return@flow
            } catch (e: Exception){
                emit(Resource.Error("No se pudo cargar los datos"))
                return@flow

            }
            emit(Resource.Success(forecast))
            emit(Resource.Loading(false))
        }
    }
}