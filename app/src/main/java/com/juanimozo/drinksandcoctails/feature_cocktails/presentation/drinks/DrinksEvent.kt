package com.juanimozo.drinksandcoctails.feature_cocktails.presentation.drinks

import com.juanimozo.drinksandcoctails.feature_cocktails.domain.model.DrinkModel
import com.juanimozo.drinksandcoctails.feature_cocktails.domain.util.DrinkOrder

sealed class DrinksEvent {
    data class Order(val drinkOrder: DrinkOrder): DrinksEvent()
    data class MakeFavourite(val drink: DrinkModel): DrinksEvent()
    data class UndoFavourite(val drink: DrinkModel): DrinksEvent()
    object ToggleOrderSection: DrinksEvent()
}