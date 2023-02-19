package com.hramadhaan.udemylearncompose.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.hramadhaan.udemylearncompose.ui.theme.DeepBlue
import com.hramadhaan.udemylearncompose.ui.theme.DustGrey
import com.hramadhaan.udemylearncompose.ui.theme.SunnyYellow
import com.hramadhaan.udemylearncompose.ui.theme.White

@Composable
fun BookItem() {
    val modifier = Modifier
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top,
        modifier = modifier
            .width(100.dp)
            .wrapContentHeight()
            .padding(bottom = 8.dp)
    ) {
        Box(
            contentAlignment = Alignment.TopEnd
        ) {
            AsyncImage(
                model = "https://upload.wikimedia.org/wikipedia/commons/4/4b/Sebuah-seni-untuk-bersikap-bodoh-amat.jpg",
                contentDescription = "Image Item",
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .width(100.dp)
                    .height(170.dp)
                    .clip(RoundedCornerShape(6.dp))
            )
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .clip(RoundedCornerShape(bottomStart = 10.dp))
                    .background(White)
                    .padding(horizontal = 6.dp, vertical = 4.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Star Item",
                    tint = SunnyYellow,
                    modifier = modifier.size(14.dp)
                )
                Text(
                    text = "4.0", style = TextStyle(
                        fontSize = 12.sp,
                        color = DeepBlue
                    )
                )
            }
        }
        Text(
            text = "Frank Bures", style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color = DustGrey,
            )
        )
        Text(
            text = "Sebuah seni untuk bersikap bodo amat",
            style = TextStyle(
                fontSize = 12.sp,
                color = DeepBlue,
                fontWeight = FontWeight.Medium,
            ),
            overflow = TextOverflow.Ellipsis,
            maxLines = 2
        )
    }
}

@Composable
@Preview(showBackground = true)
fun BookItemPreview() {
    BookItem()
}