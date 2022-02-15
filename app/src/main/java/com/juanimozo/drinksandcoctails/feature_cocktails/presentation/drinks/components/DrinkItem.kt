package com.juanimozo.drinksandcoctails.feature_cocktails.presentation.drinks.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.juanimozo.drinksandcoctails.ui.components.Screen
import com.juanimozo.drinksandcoctails.R
import com.juanimozo.drinksandcoctails.feature_cocktails.domain.model.DrinkModel
import com.juanimozo.drinksandcoctails.ui.theme.Navy
import com.juanimozo.drinksandcoctails.ui.theme.Typography
import java.util.*

@Composable
fun DrinkItem(
    drink: DrinkModel,
    drinkImage: Int,
    navController: NavController
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)
            .clickable {
                   navController.navigate(Screen.DrinkDetails.withArgs(drink.id, drinkImage))
            },
        backgroundColor = Navy,
        elevation = 2.dp
    ) {
        // Gradient
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = drinkImage),
                contentDescription = drink.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize().padding(12.dp)
            )
            // Gradient
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 300f
                        )
                    )
            )
            Box(
                modifier = Modifier.fillMaxSize().padding(bottom = 6.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                Text(
                    modifier = Modifier,
                    text = drink.name,
                    style = MaterialTheme.typography.h3,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun DrinkItemPreview() {
//    DrinkItem(
//        drink = Drink(0, "Cosmopolitan", "","","","", 1, "", 1),
//        drinkImage = R.drawable.margarita,
//
//    )
//}