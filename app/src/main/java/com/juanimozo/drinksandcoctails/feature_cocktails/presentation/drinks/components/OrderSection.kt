package com.juanimozo.drinksandcoctails.feature_cocktails.presentation.drinks.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.juanimozo.drinksandcoctails.feature_cocktails.domain.util.DrinkOrder
import com.juanimozo.drinksandcoctails.feature_cocktails.domain.util.OrderType
import com.juanimozo.drinksandcoctails.ui.theme.Black
import com.juanimozo.drinksandcoctails.ui.theme.Typography

@Composable
fun OrderSection(
    modifier: Modifier,
    drinkOrder: DrinkOrder = DrinkOrder.Name(OrderType.Descending),
    onOrderChange: (DrinkOrder) -> Unit
) {
    Column(
        modifier = modifier
    ) {
        Text(
            modifier = Modifier.padding(start = 8.dp),
            text = "Sort By:",
            style = MaterialTheme.typography.body1
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth().padding(start = 8.dp)
        ) {
            DefaultRadioButton(
                text = "Name",
                selected = drinkOrder is DrinkOrder.Name,
                onSelect = { onOrderChange(DrinkOrder.Name(drinkOrder.orderType)) }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = "Popularity",
                selected = drinkOrder is DrinkOrder.Popularity,
                onSelect = { onOrderChange(DrinkOrder.Popularity(drinkOrder.orderType)) }
            )
        }
    }
}