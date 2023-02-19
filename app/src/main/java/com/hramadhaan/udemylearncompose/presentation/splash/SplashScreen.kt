package com.hramadhaan.udemylearncompose.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.hramadhaan.udemylearncompose.R
import com.hramadhaan.udemylearncompose.presentation.resources.RouteScreen
import com.hramadhaan.udemylearncompose.presentation.splash.view_model.SplashScreenViewModel
import com.hramadhaan.udemylearncompose.ui.theme.ColdGrey
import com.hramadhaan.udemylearncompose.ui.theme.DeepBlue
import kotlinx.coroutines.delay

@Composable
@ExperimentalMaterial3Api
fun SplashScreen(
    navController: NavController,
    splashScreenViewModel: SplashScreenViewModel = viewModel()
) {
    val modifier = Modifier

    LaunchedEffect(key1 = false) {
        delay(2000L)
        splashScreenViewModel.currentAuthStatus { isStatus ->
            if (isStatus) {
                navController.navigate(RouteScreen.HomeScreen.name) {
                    popUpTo(RouteScreen.SplashScreen.name) {
                        inclusive = true
                    }
                }
            } else {
                navController.navigate(RouteScreen.RegisterScreen.name) {
                    popUpTo(RouteScreen.SplashScreen.name) {
                        inclusive = true
                    }
                }
            }
        }
    }

    Scaffold {
        Surface(
            modifier = modifier
                .padding(it)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.main_icon),
                    contentDescription = "Splash Screen Icon",
                    modifier = modifier
                        .height(120.dp)
                        .width(120.dp)
                )
                Box(modifier = modifier.height(20.dp))
                Text(
                    stringResource(id = R.string.app_name), style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp,
                        color = ColdGrey
                    )
                )
            }
        }
    }
}