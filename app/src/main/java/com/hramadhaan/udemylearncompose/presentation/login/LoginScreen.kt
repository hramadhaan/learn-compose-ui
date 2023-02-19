@file:OptIn(ExperimentalComposeUiApi::class)

package com.hramadhaan.udemylearncompose.presentation.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.hramadhaan.udemylearncompose.R
import com.hramadhaan.udemylearncompose.commons.components.InputTextField
import com.hramadhaan.udemylearncompose.presentation.login.view_model.LoginScreenViewModel
import com.hramadhaan.udemylearncompose.presentation.resources.RouteScreen
import com.hramadhaan.udemylearncompose.ui.theme.PurplePlum
import com.hramadhaan.udemylearncompose.ui.theme.RedAlert
import com.hramadhaan.udemylearncompose.ui.theme.White
import com.hramadhaan.udemylearncompose.ui.theme.jostFamily
import kotlinx.coroutines.launch

@Composable
@ExperimentalMaterial3Api
fun LoginScreen(
    navController: NavController = rememberNavController(),
    loginScreenViewModel: LoginScreenViewModel = viewModel()
) {
    val modifier = Modifier

    var email by rememberSaveable {
        mutableStateOf("")
    }

    var password by rememberSaveable {
        mutableStateOf("")
    }

    var isSecureText by rememberSaveable {
        mutableStateOf(true)
    }

    val isOpenedDialog = remember(loginScreenViewModel.loading) {
        loginScreenViewModel.loading
    }

    val isValid = remember(email, password) {
        email.isNotEmpty() && password.isNotEmpty()
    }

    val snackbarHostState = remember {
        SnackbarHostState()
    }
    val scope = rememberCoroutineScope()

    val keyboardController = LocalSoftwareKeyboardController.current
    Scaffold(
        snackbarHost = {
            SnackbarHost(
                hostState = snackbarHostState,
                snackbar = {
                    Snackbar(snackbarData = it, containerColor = RedAlert, contentColor = White)
                },
            )
        }
    ) {
        Surface(
            modifier = modifier
                .padding(it)
                .background(Color(0xffF5F5F5))
        ) {
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top,
                modifier = modifier.padding(horizontal = 24.dp, vertical = 60.dp),
            ) {
                Text(
                    text = "Welcome Back",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                    ),
                )

                Box(modifier = modifier.height(20.dp))

                InputTextField(
                    value = email,
                    placeholder = "Enter your email here",
                    icon = {
                        Icon(imageVector = Icons.Outlined.Person, contentDescription = "Name Icon")
                    },
                    label = "Email",
                    onChangeText = {
                        email = it
                    }
                )

                Box(modifier = modifier.height(20.dp))

                InputTextField(
                    value = password,
                    placeholder = "Place the password here",
                    icon = {
                        Icon(Icons.Outlined.Lock, contentDescription = "Password Icon")
                    },
                    label = "Password",
                    onChangeText = {
                        password = it
                    },
                    secureText = isSecureText,
                    trailingIcon = {
                        IconButton(onClick = {
                            isSecureText = !isSecureText
                        }) {
                            Icon(
                                painter = painterResource(id = if (isSecureText) R.drawable.outline_visibility_24 else R.drawable.outline_visibility_off_24),
                                contentDescription = "Password Icon"
                            )
                        }
                    }
                )

                Box(modifier = modifier.height(20.dp))

                Button(
                    enabled = isValid,
                    onClick = {
                        keyboardController?.hide()
                        loginScreenViewModel.signInWithEmailAndPassword(
                            email = email,
                            password = password,
                            onError = { errorMessage ->
                                scope.launch {
                                    snackbarHostState.showSnackbar(errorMessage)
                                }
                            },
                            onSuccess = {
                                navController.navigate(RouteScreen.HomeScreen.name) {
                                    popUpTo(RouteScreen.LoginScreen.name) {
                                        inclusive = true
                                    }
                                    popUpTo(RouteScreen.RegisterScreen.name) {
                                        inclusive = true
                                    }
                                }
                            }
                        )
                    },
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = PurplePlum,
                        contentColor = White,
                    ),
                    modifier = modifier
                        .height(56.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Login", style = TextStyle(
                            fontWeight = FontWeight.W600,
                            fontSize = 16.sp,
                            fontFamily = jostFamily,
                        )
                    )
                }

                Box(modifier = modifier.height(40.dp))

                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(text = "Don't have an account ?")
                    TextButton(
                        onClick = {
                            navController.popBackStack()
                        },
                        colors = ButtonDefaults.textButtonColors(
                            contentColor = PurplePlum,
                        )
                    ) {
                        Text(text = "Sign Up")
                    }
                }
            }
            if (isOpenedDialog.value == true) {
                AlertDialog(onDismissRequest = {  }) {
                    Surface(
                        modifier = modifier
                            .wrapContentHeight()
                            .wrapContentWidth(),
                        shape = MaterialTheme.shapes.large
                    ) {
                        Column(modifier = modifier.padding(16.dp)) {
                            CircularProgressIndicator()
                        }
                    }
                }
            }
        }
    }
}

@Composable
@ExperimentalMaterial3Api
@Preview(showBackground = false)
fun LoginScreenPreview() {
    LoginScreen()
}