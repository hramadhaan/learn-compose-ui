package com.hramadhaan.udemylearncompose.presentation.resources

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hramadhaan.udemylearncompose.presentation.home.HomeScreen
import com.hramadhaan.udemylearncompose.presentation.login.LoginScreen
import com.hramadhaan.udemylearncompose.presentation.register.RegisterScreen
import com.hramadhaan.udemylearncompose.presentation.splash.SplashScreen

@Composable
@ExperimentalMaterial3Api
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = RouteScreen.SplashScreen.name) {
        composable(RouteScreen.SplashScreen.name) {
            SplashScreen(navController = navController)
        }
        composable(RouteScreen.RegisterScreen.name) {
            RegisterScreen(navController = navController)
        }
        composable(RouteScreen.LoginScreen.name) {
            LoginScreen(navController = navController)
        }
        composable(RouteScreen.HomeScreen.name) {
            HomeScreen(navController = navController)
        }
    }
}