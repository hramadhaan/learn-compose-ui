package com.hramadhaan.udemylearncompose.presentation.resources

enum class RouteScreen {
    SplashScreen,
    LoginScreen,
    RegisterScreen,
    HomeScreen;

    companion object {
        fun fromRoute(route: String?): RouteScreen = when (route?.substringBefore("/")) {
            SplashScreen.name -> SplashScreen
            LoginScreen.name -> LoginScreen
            RegisterScreen.name -> RegisterScreen
            HomeScreen.name -> HomeScreen
            null -> LoginScreen
            else -> throw IllegalArgumentException("Route not found")
        }
    }
}