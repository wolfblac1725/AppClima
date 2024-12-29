package com.erik.canseco.appclima.presentattion.screen.home

import android.Manifest
import android.content.pm.PackageManager
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.erik.canseco.appclima.R
import com.erik.canseco.appclima.domain.model.WeatherData
import com.erik.canseco.appclima.presentattion.ui.theme.AppWeatherTheme
import com.erik.canseco.appclima.presentattion.ui.theme.Typography
import com.erik.canseco.appclima.presentattion.viewmodel.ForecastViewModel
import com.erik.canseco.appclima.presentattion.widget.ItemCity
import com.erik.canseco.appclima.presentattion.widget.ItemWeather
import com.erik.canseco.appclima.presentattion.widget.ItemWeatherFirst
import com.google.android.gms.location.LocationServices

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavHostController,
    forecastViewModel: ForecastViewModel = hiltViewModel()
) {
    val forecastState = forecastViewModel.forecastState.collectAsState().value
    val fusedLocationClient = LocationServices.getFusedLocationProviderClient(LocalContext.current)
    fusedLocationClient.lastLocation.addOnSuccessListener { location ->
            if (location != null && forecastState.lat!= location.latitude && forecastState.lon != location.longitude) {
                Log.e("location", location.latitude.toString())
                Log.e("location", location.longitude.toString())
                forecastViewModel.getForecast(location.latitude, location.longitude)
            }
    }
    val granted = ContextCompat.checkSelfPermission(
        LocalContext.current,
        Manifest.permission.ACCESS_COARSE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED
    val permissionStatus = remember{ mutableStateOf(granted) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.app_name),
                        style = Typography.titleSmall
                    )
                },
                modifier = Modifier
                    .shadow(AppWeatherTheme.dimens.elevationSmall)
            )
        },
    ) {
        padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ){
            if(permissionStatus.value){
                if(forecastState.isLoading){
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(AppWeatherTheme.dimens.paddingSmall),
                        contentAlignment = Alignment.Center
                    ){
                        CircularProgressIndicator(
                            modifier = Modifier.width(AppWeatherTheme.dimens.iconLarge)
                        )
                    }
                }
                //Log.e("forecast", forecastState.forecast.toString())
                if(forecastState.forecast != null) {
                    WithPermission(forecastState.forecast)
                }
            } else {
                val permissionLauncher = rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()){ isGranted ->
                    permissionStatus.value = isGranted

                    fusedLocationClient.lastLocation.addOnSuccessListener { location ->
                        if (location != null && forecastState.lat!= location.latitude && forecastState.lon != location.longitude) {
                            Log.e("location", location.latitude.toString())
                            Log.e("location", location.longitude.toString())
                            forecastViewModel.getForecast(location.latitude, location.longitude)
                        }
                    }
                }
                SideEffect {
                    permissionLauncher.launch(Manifest.permission.ACCESS_COARSE_LOCATION)
                }
                WithoutPermission()
            }

        }

    }

}
@Composable
fun WithoutPermission(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(AppWeatherTheme.dimens.paddingMedium),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(R.string.error_permission),
            textAlign = TextAlign.Justify,
            style = Typography.bodyMedium,
        )
    }
}

@Composable
fun WithPermission(forecast: List<WeatherData>, modifier:Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(AppWeatherTheme.dimens.paddingSmall),
    ) {

        Column {
            ItemCity(forecast[0])
            LazyColumn {
                items(
                    count = forecast.size,
                    itemContent = { item ->
                        if (item == 0) {
                            ItemWeatherFirst(forecast[item])
                        } else {
                            ItemWeather(forecast[item])
                        }
                    }
                )
            }
        }
    }
}

