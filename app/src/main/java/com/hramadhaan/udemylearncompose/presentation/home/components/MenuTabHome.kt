package com.hramadhaan.udemylearncompose.presentation.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hramadhaan.udemylearncompose.ui.theme.DeepBlue
import com.hramadhaan.udemylearncompose.ui.theme.DustGrey

@Composable
fun MenuTabHome() {
    val list: List<String> =
        listOf<String>("All Result", "Free", "Premium", "Author", "Genres", "Comedy", "Fictions")

    val selectedIndex = remember {
        mutableStateOf(0)
    }
    LazyRow(modifier = Modifier.padding(horizontal = 22.dp)) {
        items(count = list.size) { index ->
            Text(
                text = list[index],
                style = TextStyle(
                    color = if (selectedIndex.value == index) DeepBlue else DustGrey,
                    fontWeight = if (selectedIndex.value == index) FontWeight.Bold else FontWeight.Normal
                ),
                modifier = Modifier
                    .padding(
                        end = 22.dp,
                        top = 12.dp,
                        bottom = 12.dp,
                    )
                    .clickable {
                        selectedIndex.value = index
                    }
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun MenuTabHomePreview() {
    MenuTabHome()
}