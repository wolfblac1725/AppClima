package com.erik.canseco.appclima.presentattion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.erik.canseco.appclima.presentattion.screen.home.HomeScreen
import com.erik.canseco.appclima.util.Screen

@Composable
fun NavController() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ){
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }
    }
}