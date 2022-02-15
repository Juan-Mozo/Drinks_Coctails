package com.juanimozo.drinksandcoctails.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.juanimozo.drinksandcoctails.R

val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily(
            Font(
                resId = R.font.quicksand_regular,
                weight = FontWeight.Normal,
                style = FontStyle.Normal
            )
        ),
        fontSize = 16.sp,
        color = Cream
    ),
    h1 = TextStyle(
        fontFamily = FontFamily(
            Font(
                resId = R.font.montserrat_medium,
                weight = FontWeight.Medium,
                style = FontStyle.Normal
            )
        ),
        fontSize = 30.sp,
        color = DarkYellow,
        textAlign = TextAlign.Center
    ),
    h2 = TextStyle(
        fontFamily = FontFamily(
            Font(
                resId = R.font.montserrat_regular,
                weight = FontWeight.Normal,
                style = FontStyle.Normal
            )
        ),
        fontSize = 22.sp,
        color = DarkYellow
    ),
    h3 = TextStyle(
        fontFamily = FontFamily(
            Font(
                resId = R.font.montserrat_regular,
                weight = FontWeight.Normal,
                style = FontStyle.Normal
            )
        ),
        fontSize = 20.sp,
        color = DarkYellow
    ),
    subtitle1 = TextStyle(
        fontFamily = FontFamily(
            Font(
                resId = R.font.montserrat_thin,
                weight = FontWeight.Thin,
                style = FontStyle.Normal
            )
        ),
        fontSize = 18.sp,
        color = Beige,
        textAlign = TextAlign.Justify
    ),
    subtitle2 = TextStyle(
        fontFamily = FontFamily(
            Font(
                resId = R.font.montserrat_thin,
                weight = FontWeight.Thin,
                style = FontStyle.Normal
            )
        ),
        fontSize = 18.sp,
        color = Beige,
        textAlign = TextAlign.Justify
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)