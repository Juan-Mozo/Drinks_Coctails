package com.juanimozo.drinksandcoctails.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.juanimozo.drinksandcoctails.feature_cocktails.domain.model.DrinkModel
import com.juanimozo.drinksandcoctails.feature_cocktails.presentation.drinks.DrinksViewModel
import com.juanimozo.drinksandcoctails.ui.theme.Beige

@Composable
fun FavouriteButton(
    viewModel: DrinksViewModel,
    drink: DrinkModel
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (drink.favourite == 1) {
            // Si la receta ya está en favoritos

            Text(
                text = "You liked this recipe",
                color = Beige,
                modifier = Modifier.padding(end = 8.dp)
            )

            IconButton(
                modifier = Modifier.size(30.dp),
                onClick = {
                    viewModel.updateFavourite(0, drink.id)
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = "Favourite",
                    tint = Color.Red
                )
            }

        } else {
            // Si la receta no está en favoritos
            Text(
                text = "Did you like this recipe?",
                color = Beige,
                modifier = Modifier.padding(end = 8.dp)
            )

            IconButton(
                modifier = Modifier.size(30.dp),
                onClick = {
                    viewModel.updateFavourite(1, drink.id)
                }
            ) {
                Icon(
                    imageVector = Icons.Outlined.Favorite,
                    contentDescription = "Favourite",
                    tint = Color.LightGray
                )
            }
        }
    }
}