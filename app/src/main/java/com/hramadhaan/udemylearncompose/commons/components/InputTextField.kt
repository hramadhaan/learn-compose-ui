package com.hramadhaan.udemylearncompose.commons.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hramadhaan.udemylearncompose.ui.theme.DarkGrey

@Composable
@ExperimentalMaterial3Api
fun InputTextField(
    value: String,
    onChangeText: (String) -> Unit = {},
    placeholder: String,
    icon: @Composable() () -> Unit,
    trailingIcon: @Composable() () -> Unit = {},
    label: String,
    secureText: Boolean = false,
    modifier: Modifier = Modifier.fillMaxWidth()
) {
    Column() {
        Text(
            text = label,
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                color = DarkGrey
            )
        )
        Box(modifier = Modifier.height(4.dp))
        OutlinedTextField(
            value = value,
            onValueChange = onChangeText,
            placeholder = {
                Text(
                    text = placeholder,
                    style = TextStyle(
                        fontWeight = FontWeight.Medium,
                        color = DarkGrey,
                        fontSize = 14.sp,
                    )
                )
            },
            trailingIcon = trailingIcon,
            leadingIcon = icon,
            visualTransformation = if (secureText) PasswordVisualTransformation() else VisualTransformation.None,
            modifier = modifier,
            shape = RoundedCornerShape(14.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = Color(0xFFFAFAFF),
                placeholderColor = DarkGrey,
                disabledPlaceholderColor = DarkGrey,
                focusedLeadingIconColor = DarkGrey,
                disabledLeadingIconColor = DarkGrey,
                errorLeadingIconColor = DarkGrey,
                unfocusedLeadingIconColor = DarkGrey,
                disabledBorderColor = Color(0xFFF0F1F9),
                errorBorderColor = Color(0xFFF0F1F9),
                focusedBorderColor = Color(0xFFF0F1F9),
                unfocusedBorderColor = Color(0xFFF0F1F9),
                disabledTrailingIconColor = DarkGrey,
                errorTrailingIconColor = DarkGrey,
                focusedTrailingIconColor = DarkGrey,
                unfocusedTrailingIconColor = DarkGrey,
            )
        )
    }
}

@ExperimentalMaterial3Api
@Composable
@Preview
fun InputTextFieldPreview() {
    InputTextField(
        value = "",
        label = "Your Name",
        onChangeText = {},
        placeholder = "Enter your name",
        icon = {
            Icon(imageVector = Icons.Outlined.Person, contentDescription = "Leading Icon")
        },
        trailingIcon = {
            Icon(
                painter = painterResource(com.hramadhaan.udemylearncompose.R.drawable.outline_visibility_24),
                contentDescription = "Trailing Icon"
            )
        }
    )
}