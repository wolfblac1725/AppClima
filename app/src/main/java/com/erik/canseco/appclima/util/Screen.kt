package com.erik.canseco.appclima.util


sealed class Screen (val route: String) {
    data object Home: Screen("home")
}