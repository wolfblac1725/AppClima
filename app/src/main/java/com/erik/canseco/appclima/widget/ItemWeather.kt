package com.erik.canseco.appclima.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.erik.canseco.appclima.R
import com.erik.canseco.appclima.data.remote.response.ItemWeather
import com.erik.canseco.appclima.util.Utility
import com.erik.canseco.appclima.util.Utility.formatTemp

@Composable
fun ItemWeatherFirst(item: ItemWeather, modifier: Modifier = Modifier) {
    val weather = item.weather[0]
    val icon = Utility.iconWeather(weather.icon)
    Row(
        modifier= modifier.fillMaxWidth()
    ) {
        Column(
            modifier= modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        ) {
            Text(
                stringResource(R.string.date, Utility.formatDate(item.dt)),
                style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                stringResource(R.string.max_temp, formatTemp(item.temp.max)),
                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                stringResource(R.string.min_temp, formatTemp(item.temp.min)),
                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                stringResource(R.string.humidity, item.humidity),
                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(stringResource(R.string.pressure, item.pressure),
                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
            )
        }
        Column(
            modifier= modifier
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(
                    id = icon
                ),
                modifier = Modifier
                    .height(150.dp)
                    .width(150.dp),
                contentDescription = weather.main
            )
            Text(
                text = weather.main,
                style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
            )
        }
    }
}

@Composable
fun ItemWeather(item: ItemWeather, modifier: Modifier = Modifier) {
    val weather = item.weather[0]
    val icon = Utility.iconWeather(weather.icon)
    Spacer(modifier = Modifier.height(8.dp))
    Row(
        modifier= modifier.fillMaxWidth()
    ) {
        Column(
            modifier= modifier
                .weight(1f)
                .align(Alignment.CenterVertically),
        ) {
            Text(
                stringResource(R.string.date, Utility.formatDate(item.dt)),
                style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                stringResource(R.string.max_temp, formatTemp(item.temp.max)),
                style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                stringResource(R.string.min_temp, formatTemp(item.temp.min)),
                style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
            )
        }
        Column(
            modifier= modifier
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(
                    id = icon
                ),
                modifier = Modifier
                    .height(80.dp)
                    .width(80.dp),
                contentDescription = weather.main
            )
            Text(
                text = weather.main,
                style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
            )
        }
    }
}