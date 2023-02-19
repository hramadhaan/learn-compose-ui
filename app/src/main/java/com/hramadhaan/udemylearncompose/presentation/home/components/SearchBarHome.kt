package com.hramadhaan.udemylearncompose.presentation.home.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hramadhaan.udemylearncompose.ui.theme.DarkGrey
import com.hramadhaan.udemylearncompose.ui.theme.LightGrey

@Composable
@ExperimentalMaterial3Api
fun SearchBarHome() {
    val valueSearch = rememberSaveable() {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = valueSearch.value,
        onValueChange = {
            valueSearch.value = it
        },
        leadingIcon = {
            Icon(imageVector = Icons.Outlined.Search, contentDescription = "Search on Text Field")
        },
        maxLines = 1,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 22.dp, end = 22.dp),
        placeholder = {
            Text(
                text = "Search Book",
                style = TextStyle(
                    color = DarkGrey,
                ),
            )
        },
        shape = RoundedCornerShape(25.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = LightGrey,
            focusedBorderColor = DarkGrey,
            unfocusedBorderColor = DarkGrey,
            errorBorderColor = DarkGrey,
            disabledBorderColor = DarkGrey
        )
    )
}

@Composable
@ExperimentalMaterial3Api
@Preview(showBackground = true)
fun SearchBarHomePreview() {
    SearchBarHome()
}