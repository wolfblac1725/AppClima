package com.erik.canseco.appclima.data.repository


import com.erik.canseco.appclima.data.local.WeatherDatabase
import com.erik.canseco.appclima.data.remote.WeatherApi
import com.erik.canseco.appclima.data.remote.model.response.toCityEntity
import com.erik.canseco.appclima.data.remote.model.response.toWeatherEntity
import com.erik.canseco.appclima.domain.model.WeatherData
import com.erik.canseco.appclima.domain.model.toWeatherData
import com.erik.canseco.appclima.domain.repository.WeatherRepository
import com.erik.canseco.appclima.util.Constant
import com.erik.canseco.appclima.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi,
    private val db: WeatherDatabase
): WeatherRepository {
    override suspend fun getWeather(lat: Double, lon: Double): Flow<Resource<List<WeatherData>>> {
        return flow {
            emit(Resource.Loading(true))
            val forecast = try {
                val city = db.weatherDao.getCity(lon, lat)
                if (city.isNotEmpty()) {
                    val listWeather = db.weatherDao.getWeatherDate(System.currentTimeMillis())
                    listWeather.map {
                        it.toWeatherData(
                            name = city[0].name,
                            country = city[0].country,
                            lon = city[0].lon,
                            lat = city[0].lat
                        )
                    }

                } else {
                    val forecastLatLon = api.getForecastLatLon(lat, lon)
                    val listWeather: List<WeatherData> = forecastLatLon.list.map {
                        it.toWeatherData(
                            name = forecastLatLon.city.name,
                            country = forecastLatLon.city.country,
                            lon = forecastLatLon.city.coord.lon,
                            lat = forecastLatLon.city.coord.lat
                        )
                    }
                    db.weatherDao.deleteCity()
                    db.weatherDao.deleteWeather()
                    db.weatherDao.upsertCity(forecastLatLon.city.toCityEntity())
                    db.weatherDao.upsertWeather(
                        forecastLatLon.list.map {
                            it.toWeatherEntity(forecastLatLon.city.id.toInt())
                        }
                    )
                    listWeather
                }
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error(Constant.ERROR_LOADING_DATA))
                return@flow
            } catch (e: HttpException) {
                emit(Resource.Error(Constant.ERROR_LOADING_DATA))
                return@flow
            } catch (e: Exception){
                emit(Resource.Error(Constant.ERROR_LOADING_DATA))
                return@flow
            }
            emit(Resource.Success(forecast))
            emit(Resource.Loading(false))

        }
    }
}