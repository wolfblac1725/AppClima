package com.erik.canseco.appclima.di

import com.erik.canseco.appclima.data.remote.APIKeyInterceptor
import com.erik.canseco.appclima.data.remote.WeatherApi
import com.erik.canseco.appclima.util.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    private val client = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .addInterceptor(APIKeyInterceptor())
        .build()

    @Singleton
    @Provides

    fun providesWeatherApi(): WeatherApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constant.BASE_URL)
            .client(client)
            .build().create(WeatherApi::class.java)
    }
}