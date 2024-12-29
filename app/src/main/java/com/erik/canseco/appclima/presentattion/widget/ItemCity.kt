package com.erik.canseco.appclima.presentattion.widget

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.erik.canseco.appclima.R
import com.erik.canseco.appclima.domain.model.WeatherData
import com.erik.canseco.appclima.presentattion.ui.theme.AppWeatherTheme
import com.erik.canseco.appclima.presentattion.ui.theme.Typography

@Composable
fun ItemCity(city: WeatherData, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxWidth().padding(AppWeatherTheme.dimens.paddingSmall),
    ){
        Column(modifier = modifier.fillMaxWidth()
        ) {
            Text(
                "${city.name} - ${city.country}",
                style = Typography.headlineMedium,
            )
            Spacer(modifier.height(AppWeatherTheme.dimens.paddingSmall))
            Text(
                stringResource(R.string.text_coordinate, city.lat.toString(), city.lon.toString()),
                style = Typography.bodySmall
            )
            Spacer(modifier.height(AppWeatherTheme.dimens.paddingSmall))
        }
    }
}