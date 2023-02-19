package com.hramadhaan.udemylearncompose.presentation.home

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.hramadhaan.udemylearncompose.presentation.home.components.*

@Composable
@ExperimentalMaterial3Api
fun HomeScreen(navController: NavController = rememberNavController()) {
    val modifier = Modifier
    Scaffold() { innerPadding ->
        Surface(modifier = modifier.padding(innerPadding)) {
            Column(
                modifier = modifier.verticalScroll(rememberScrollState())
            ) {
                HeaderHome()
                SearchBarHome()
                Box(modifier = Modifier.height(12.dp))
                MenuTabHome()
                Box(modifier = Modifier.height(12.dp))
                MenuSection(labelName = "Recommended For You", labelAction = "See All")
                Box(modifier = Modifier.height(12.dp))
                Row(
                    modifier = modifier
                        .padding(horizontal = 22.dp)
                        .horizontalScroll(
                            rememberScrollState()
                        )
                ) {
                    BookItem()
                    Box(modifier = modifier.width(18.dp))
                    BookItem()
                    Box(modifier = modifier.width(18.dp))
                    BookItem()
                    Box(modifier = modifier.width(18.dp))
                    BookItem()
                    Box(modifier = modifier.width(18.dp))
                    BookItem()
                }
                Box(modifier = Modifier.height(18.dp))
                MenuSection(labelName = "Popular Now", labelAction = "See All")
                Box(modifier = Modifier.height(12.dp))
                Row(
                    modifier = modifier
                        .padding(horizontal = 22.dp)
                        .horizontalScroll(
                            rememberScrollState()
                        )
                ) {
                    BookItem()
                    Box(modifier = modifier.width(18.dp))
                    BookItem()
                    Box(modifier = modifier.width(18.dp))
                    BookItem()
                    Box(modifier = modifier.width(18.dp))
                    BookItem()
                    Box(modifier = modifier.width(18.dp))
                    BookItem()
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = false)
@ExperimentalMaterial3Api
fun HomeScreenPreview() {
    HomeScreen()
}