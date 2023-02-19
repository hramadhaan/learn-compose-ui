@file:OptIn(ExperimentalComposeUiApi::class)

package com.hramadhaan.udemylearncompose.presentation.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import com.hramadhaan.udemylearncompose.presentation.register.view_model.RegisterScreenViewModel
import com.hramadhaan.udemylearncompose.presentation.resources.RouteScreen
import com.hramadhaan.udemylearncompose.ui.theme.*
import kotlinx.coroutines.launch

@Composable
@ExperimentalMaterial3Api
fun RegisterScreen(
    navController: NavController = rememberNavController(),
    registerScreenViewModel: RegisterScreenViewModel = viewModel()
) {
    val modifier = Modifier
    var name by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var isVisible by remember {
        mutableStateOf(true)
    }
    var isCheckedTerm by remember {
        mutableStateOf(false)
    }

    val isValid = remember(name, email, password, isCheckedTerm) {
        name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && isCheckedTerm
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
                modifier = modifier.padding(horizontal = 24.dp, vertical = 60.dp)
            ) {
                Text(
                    text = "Create an Account",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                    ),
                )
                Box(modifier = modifier.height(20.dp))
                InputTextField(
                    value = name,
                    label = "Full Name",
                    placeholder = "Enter your name",
                    onChangeText = { value ->
                        name = value
                    },
                    icon = {
                        Icon(imageVector = Icons.Outlined.Person, contentDescription = "Name Icon")
                    },
                )
                Box(modifier = modifier.height(20.dp))
                InputTextField(
                    value = email,
                    label = "E-Mail",
                    placeholder = "Enter your e-mail",
                    onChangeText = { value ->
                        email = value
                    },
                    icon = {
                        Icon(imageVector = Icons.Outlined.Email, contentDescription = "Email Icon")
                    },
                )
                Box(modifier = modifier.height(20.dp))
                InputTextField(
                    value = password,
                    placeholder = "Place at the password here",
                    onChangeText = {
                        password = it
                    },
                    icon = {
                        Icon(Icons.Outlined.Lock, contentDescription = "Password Icon")
                    },
                    label = "Password",
                    secureText = isVisible,
                    trailingIcon = {
                        IconButton(onClick = {
                            isVisible = !isVisible
                        }) {
                            Icon(
                                painter = painterResource(id = if (isVisible) R.drawable.outline_visibility_24 else R.drawable.outline_visibility_off_24),
                                contentDescription = "Password Icon"
                            )
                        }
                    }
                )
//                Box(modifier = modifier.height())
                Divider(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(vertical = 20.dp)
                )

                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.Top,
                ) {
                    Checkbox(
                        checked = isCheckedTerm,
                        onCheckedChange = {
                            isCheckedTerm = !isCheckedTerm
                        },
                        colors = CheckboxDefaults.colors(
                            checkedColor = Color.Transparent,
                            checkmarkColor = PurplePlum,
                        ),
                    )
                    Text(
                        text = "By continuing you accept our Privacy Policy and Term of Use",
                        style = TextStyle(
                            color = DarkGrey,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.W500,
                        )
                    )
                }

                Box(modifier = modifier.height(20.dp))

                Button(
                    enabled = isValid,
                    onClick = {
                        registerScreenViewModel.createUserWithEmailAndPassword(
                            email = email,
                            password = password,
                            fullName = name,
                            onSuccess = {
                                navController.navigate(RouteScreen.HomeScreen.name) {
                                    popUpTo(RouteScreen.RegisterScreen.name) {
                                        inclusive = true
                                    }
                                }
                            },
                            onError = { errorMessage ->
                                scope.launch {
                                    snackbarHostState.showSnackbar(errorMessage)
                                }
                            })
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
                        text = "Sign Up", style = TextStyle(
                            fontWeight = FontWeight.W600,
                            fontSize = 16.sp,
                            fontFamily = jostFamily,
                        )
                    )
                }

                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(text = "Already have an account?")
                    TextButton(
                        onClick = {
                            navController.navigate(RouteScreen.LoginScreen.name)
                        },
                        colors = ButtonDefaults.textButtonColors(
                            contentColor = PurplePlum
                        )
                    ) {
                        Text(text = "Login")
                    }
                }
            }
        }
    }
}

@ExperimentalMaterial3Api
@Preview(showBackground = false)
@Composable
fun RegisterScreenPreview() {
    RegisterScreen()
}