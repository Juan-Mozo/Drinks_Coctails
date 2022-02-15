package com.juanimozo.drinksandcoctails.feature_cocktails.presentation.drinks

import com.juanimozo.drinksandcoctails.feature_cocktails.domain.model.DrinkModel

data class DrinkState(
    val drink: DrinkModel = DrinkModel(
        0, "","","","","",0,"",0
    ),
    var isFavourite: Boolean = false
)
