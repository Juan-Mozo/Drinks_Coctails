package com.juanimozo.drinksandcoctails.feature_cocktails.presentation.drinks

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.juanimozo.drinksandcoctails.feature_cocktails.domain.model.DrinkModel
import com.juanimozo.drinksandcoctails.ui.components.FavouriteButton

@Composable
fun DrinkDetails(
    viewModel: DrinksViewModel = hiltViewModel(),
    drinkId: Int,
    drinkImage: Int
) {
    viewModel.getDrink(drinkId)

    val drink: DrinkModel = viewModel.currentDrink.value.drink

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        // Header
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = drinkImage),
                contentDescription = drink.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
            )
            Text(
                text = drink.name,
                style = MaterialTheme.typography.h1
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        // Main Content
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = drink.description,
                style = MaterialTheme.typography.subtitle1
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Ingredients",
                style = MaterialTheme.typography.h2
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = drink.ingredient,
                style = MaterialTheme.typography.body1
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Instructions",
                style = MaterialTheme.typography.h2
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = drink.recipe,
                style = MaterialTheme.typography.body1
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center
        ) {
            FavouriteButton(viewModel = viewModel, drink = drink)
        }

        Spacer(modifier = Modifier.height(80.dp))
    }
}