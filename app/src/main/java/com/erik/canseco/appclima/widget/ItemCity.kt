package com.erik.canseco.appclima.widget

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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.erik.canseco.appclima.R
import com.erik.canseco.appclima.data.remote.response.City

@Composable
fun ItemCity(city: City, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxWidth().padding(top = 8.dp),
    ){
        Column(modifier = modifier.fillMaxWidth()
        ) {
            Text(
                "${city.name} - ${city.country}",
                style = TextStyle(
                    fontSize = 22.sp,
                    fontWeight = FontWeight.SemiBold,
                )
            )
            Spacer(modifier.height(8.dp))
            Text(
                stringResource(R.string.text_coordinate, city.coord.lat.toString(), city.coord.lon.toString()),
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                )
            )
            Spacer(modifier.height(8.dp))
        }
    }
}