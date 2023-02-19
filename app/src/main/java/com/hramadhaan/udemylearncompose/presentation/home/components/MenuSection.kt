package com.hramadhaan.udemylearncompose.presentation.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hramadhaan.udemylearncompose.ui.theme.ColdGrey
import com.hramadhaan.udemylearncompose.ui.theme.DeepBlue

@Composable
fun MenuSection(
    labelName: String,
    labelAction: String,
    onClickAction: () -> Unit = {}
) {
    val modifier = Modifier
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 22.dp)
    ) {
        Text(
            text = labelName,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = DeepBlue
            )
        )
        Text(
            text = labelAction,
            style = TextStyle(
                color = ColdGrey,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp
            ),
            modifier = modifier.clickable {
                onClickAction()
            }
        )
    }
}

@Composable
@Preview(showBackground = true)
fun MenuSectionPreview() {
    MenuSection(
        labelName = "Recommended For You",
        labelAction = "See All"
    )
}