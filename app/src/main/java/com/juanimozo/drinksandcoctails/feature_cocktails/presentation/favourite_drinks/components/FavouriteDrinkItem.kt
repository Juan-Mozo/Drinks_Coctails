package com.juanimozo.drinksandcoctails.feature_cocktails.presentation.favourite_drinks.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.juanimozo.drinksandcoctails.feature_cocktails.domain.model.DrinkModel
import com.juanimozo.drinksandcoctails.ui.components.Screen
import com.juanimozo.drinksandcoctails.ui.theme.Navy

@Composable
fun FavouriteDrinkItem(
    drink: DrinkModel,
    drinkImage: Int,
    navController: NavController
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .clickable {
                navController.navigate(Screen.DrinkDetails.withArgs(drink.id, drinkImage))
            },
        backgroundColor = Navy,
        elevation = 2.dp
    ) {
        // Gradient
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = drinkImage),
                contentDescription = drink.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(150.dp)
                    .width(150.dp)
                    .padding(12.dp)
            )

            Text(
                modifier = Modifier,
                text = drink.name,
                style = MaterialTheme.typography.h3,
                textAlign = TextAlign.Center
            )
        }
    }
}