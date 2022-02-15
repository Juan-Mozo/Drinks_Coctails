package com.juanimozo.drinksandcoctails.feature_cocktails.domain.use_case

data class DrinkUseCases(
    val getDrinks: GetDrinks,
    val getFavouriteDrinks: GetFavouriteDrinks,
    val searchDrink: SearchDrink,
    val updateFavourite: UpdateFavourite,
    val getDrink: GetDrink
)
