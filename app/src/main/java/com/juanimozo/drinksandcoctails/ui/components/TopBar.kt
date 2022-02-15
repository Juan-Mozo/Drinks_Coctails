package com.juanimozo.drinksandcoctails.ui.theme

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopBar(text: String) {
    TopAppBar(
        title = {
            Text(
                text = text,
                fontSize = 18.sp
            )
        },
        backgroundColor = Navy,
        contentColor = Cream,
        elevation = 2.dp
    )
}

@Preview(showBackground = true)
@Composable
fun TobBarReview() {
    TopBar("Hello World")
}