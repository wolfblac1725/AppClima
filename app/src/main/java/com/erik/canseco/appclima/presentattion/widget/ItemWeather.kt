package com.erik.canseco.appclima.presentattion.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.erik.canseco.appclima.R
import com.erik.canseco.appclima.domain.model.WeatherData
import com.erik.canseco.appclima.presentattion.ui.theme.AppWeatherTheme
import com.erik.canseco.appclima.presentattion.ui.theme.Typography
import com.erik.canseco.appclima.util.Utility
import com.erik.canseco.appclima.util.Utility.formatDate
import com.erik.canseco.appclima.util.Utility.formatTemp

@Composable
fun ItemWeatherFirst(item: WeatherData, modifier: Modifier = Modifier) {
    val icon = Utility.iconWeather(item.weatherIcon)

    Card {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = AppWeatherTheme.dimens.paddingMedium),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                formatDate(item.dt),
                style = Typography.titleLarge
            )
            Spacer(modifier = Modifier.height(AppWeatherTheme.dimens.paddingSmall))
            Image(
                painter = painterResource(icon),
                contentDescription = item.weatherDescription,
                modifier = Modifier
                    .height(AppWeatherTheme.dimens.iconWeatherMedium)
                    .width(AppWeatherTheme.dimens.iconWeatherMedium)
            )
            Spacer(modifier = Modifier.height(AppWeatherTheme.dimens.paddingSmall))
            Text(
                text = item.weatherDescription,
                style = Typography.titleSmall
            )
            Spacer(modifier = Modifier.height(AppWeatherTheme.dimens.paddingSmall))
            Text(
                stringResource(
                    R.string.max_temp_min,
                    formatTemp(item.tempMax),
                    formatTemp(item.tempMin)
                ),
                style = Typography.titleMedium
            )
            Spacer(modifier = Modifier.height(AppWeatherTheme.dimens.paddingSmall))
            Text(
                stringResource(R.string.humidity, item.humidity),
                style = Typography.titleSmall
            )
            Spacer(modifier = Modifier.height(AppWeatherTheme.dimens.paddingSmall))
            Text(
                stringResource(R.string.pressure, item.pressure),
                style = Typography.titleSmall
            )
        }
    }
}

@Composable
fun ItemWeather(item: WeatherData, modifier: Modifier = Modifier) {
    val icon = Utility.iconWeather(item.weatherIcon)
    Spacer(modifier = Modifier.height(AppWeatherTheme.dimens.paddingSmall))
    Card {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(AppWeatherTheme.dimens.paddingSmall)
                .height(AppWeatherTheme.dimens.cardHeight)
        ) {
            Column(
                modifier = modifier
                    .weight(1f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    formatDate(item.dt),
                    style = Typography.titleMedium
                )
                Spacer(modifier = Modifier.height(AppWeatherTheme.dimens.paddingSmall))
                Text(
                    stringResource(R.string.max_temp_min, formatTemp(item.tempMax), formatTemp(item.tempMin)),
                    style = Typography.titleSmall
                )
                Spacer(modifier = Modifier.height(AppWeatherTheme.dimens.paddingSmall))
            }
            Column(
                modifier = modifier
                    .weight(1f)
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(
                        id = icon
                    ),
                    modifier = Modifier
                        .height(AppWeatherTheme.dimens.iconWeatherSmall)
                        .width(AppWeatherTheme.dimens.iconWeatherSmall),
                    contentDescription = item.weatherDescription
                )
                Text(
                    text = item.weatherDescription,
                    style = Typography.labelSmall
                )
            }
        }
    }
}