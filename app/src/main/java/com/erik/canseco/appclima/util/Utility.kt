package com.erik.canseco.appclima.util

import com.erik.canseco.appclima.R
import java.text.SimpleDateFormat
import java.util.Date

object Utility {
    fun formatTemp(temp: Double): String {
        return String.format("%.2f°",temp)
    }
    fun iconWeather(icon: String): Int {
        return when(icon) {
            "01d" -> R.drawable._01d
            "01n" -> R.drawable._01n
            "02d" -> R.drawable._02d
            "02n" -> R.drawable._02n
            "03d" -> R.drawable._03
            "03n" -> R.drawable._03
            "04d" -> R.drawable._03n
            "04n" -> R.drawable._03n
            "09d" -> R.drawable._09d
            "09n" -> R.drawable._09n
            "10d" -> R.drawable._10d
            "10n" -> R.drawable._10n
            "11d" -> R.drawable._11d
            "11n" -> R.drawable._11n
            "13d" -> R.drawable._13d
            "13n" -> R.drawable._13n
            "50d" -> R.drawable._50d
            "50n" -> R.drawable._50n
            else -> R.drawable._03
        }
    }
    fun formatDate(date: Long): String {
        val sdf = SimpleDateFormat("dd/MM/yyyy")
        return sdf.format(Date(date * 1000))

    }
}