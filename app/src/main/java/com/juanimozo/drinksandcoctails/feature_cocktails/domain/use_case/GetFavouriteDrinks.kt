package com.juanimozo.drinksandcoctails.feature_cocktails.domain.use_case

import com.juanimozo.drinksandcoctails.feature_cocktails.domain.model.DrinkModel
import com.juanimozo.drinksandcoctails.feature_cocktails.domain.repository.DrinkRepository
import kotlinx.coroutines.flow.Flow

class GetFavouriteDrinks(
    private val repository: DrinkRepository
) {
    operator fun invoke(): Flow<List<DrinkModel>> {
        return repository.getFavouriteDrinks()
    }
}