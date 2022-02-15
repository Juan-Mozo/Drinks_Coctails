package com.juanimozo.drinksandcoctails.feature_cocktails.presentation.favourite_drinks

import com.juanimozo.drinksandcoctails.feature_cocktails.domain.model.DrinkModel

data class FavouriteDrinksState(
    val drinks: List<DrinkModel> = emptyList()
)