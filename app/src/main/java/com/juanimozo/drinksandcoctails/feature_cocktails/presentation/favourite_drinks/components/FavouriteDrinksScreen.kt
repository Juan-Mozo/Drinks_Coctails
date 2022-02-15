package com.juanimozo.drinksandcoctails.feature_cocktails.presentation.favourite_drinks.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.juanimozo.drinksandcoctails.feature_cocktails.data.getImage
import com.juanimozo.drinksandcoctails.feature_cocktails.presentation.drinks.DrinksViewModel
import com.juanimozo.drinksandcoctails.ui.theme.Beige
import com.juanimozo.drinksandcoctails.ui.theme.TopBar

@Composable
fun FavouritesScreen(
    navController: NavController
) {

    val viewModel: DrinksViewModel = hiltViewModel()

    viewModel.getFavouriteDrinks()
    val state = viewModel.favouriteState.value

    Scaffold(
        topBar = { TopBar(text = "Favourite Drinks") }
    ) {
        if (state.drinks.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = "No favourite drinks yet",
                    style = MaterialTheme.typography.h2
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(state.drinks) { drink ->
                    val drinkImage = getImage(drink.name)
                    FavouriteDrinkItem(
                        drink = drink,
                        drinkImage = drinkImage,
                        navController = navController
                    )
                    Divider(color = Beige)
                }
            }
        }
    }
}