package com.erik.canseco.appclima.screen.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.erik.canseco.appclima.domain.repository.WeatherRepository
import com.erik.canseco.appclima.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForecastViewModel @Inject constructor(
    private val repository: WeatherRepository
):ViewModel() {
    private val _forecastState = MutableStateFlow(ForecastState())
    val forecastState = _forecastState.asStateFlow()

    fun getForecast(lat: Double, lon: Double) {
        viewModelScope.launch {
            _forecastState.update {
                it.copy(isLoading = true)
            }
            viewModelScope.launch {
                _forecastState.update {
                    it.copy(lat = lat, lon = lon)
                }
            }
            repository.getWeather(lat, lon).collectLatest { result ->
                when(result){
                    is Resource.Error -> {
                        _forecastState.update {
                            it.copy(isLoading = false, error = result.message ?: "Error desconocido")
                        }
                    }
                    is Resource.Loading ->
                        _forecastState.update {
                            it.copy(isLoading = result.isLoading)
                        }
                    is Resource.Success -> {
                       _forecastState.update {
                           it.copy(isLoading = false, forecast = result.data )
                        }
                    }
                }
            }

        }

    }
}