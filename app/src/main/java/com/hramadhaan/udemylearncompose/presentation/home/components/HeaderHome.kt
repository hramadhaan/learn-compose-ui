package com.hramadhaan.udemylearncompose.presentation.home.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.hramadhaan.udemylearncompose.ui.theme.DeepBlue
import com.hramadhaan.udemylearncompose.ui.theme.LightGrey

@Composable
@ExperimentalMaterial3Api
fun HeaderHome() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(start = 22.dp, end = 22.dp, top = 22.dp, bottom = 12.dp)
            .fillMaxWidth()
    ) {
//        Image and Name
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
        ) {
            AsyncImage(
                model = "https://randomuser.me/api/portraits/men/75.jpg",
                contentDescription = "Avatar URL",
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .border(2.dp, LightGrey, CircleShape)
            )
            Box(modifier = Modifier.width(12.dp))
            Column() {
                Text(
                    text = "Hi, Hanif Ramadhan", style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = DeepBlue,
                    )
                )
                Text(
                    text = "What are you reading today ?",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        color = DeepBlue
                    )
                )
            }
        }
//        Button Actions
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BadgedBox(
                badge = {
                    Badge {
                        Text("9")
                    }
                },
                modifier = Modifier.clickable { },
            ) {
                Icon(
                    imageVector = Icons.Outlined.Notifications,
                    contentDescription = "Notification Icons"
                )
            }
            Box(modifier = Modifier.width(22.dp))
            BadgedBox(
                badge = {
                    Badge {
                        Text("9")
                    }
                },
                modifier = Modifier.clickable { },
            ) {
                Icon(
                    imageVector = Icons.Outlined.ShoppingCart,
                    contentDescription = "Notification Icons"
                )
            }
        }
    }
}


@Composable
@ExperimentalMaterial3Api
@Preview(showBackground = true)
fun HeaderHomePreview() {
    HeaderHome()
}