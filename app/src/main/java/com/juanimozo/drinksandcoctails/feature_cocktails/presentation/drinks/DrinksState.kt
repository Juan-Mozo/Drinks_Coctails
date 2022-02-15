package com.juanimozo.drinksandcoctails.feature_cocktails.presentation.drinks

import com.juanimozo.drinksandcoctails.feature_cocktails.domain.model.DrinkModel
import com.juanimozo.drinksandcoctails.feature_cocktails.domain.util.DrinkOrder
import com.juanimozo.drinksandcoctails.feature_cocktails.domain.util.OrderType

data class DrinksState(
    val drinks: List<DrinkModel> = emptyList(),
    val drinkOrder: DrinkOrder = DrinkOrder.Name(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)