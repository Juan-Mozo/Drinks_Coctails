package com.juanimozo.drinksandcoctails.feature_cocktails.domain.use_case

import com.juanimozo.drinksandcoctails.feature_cocktails.domain.repository.DrinkRepository
import kotlinx.coroutines.flow.Flow

class UpdateFavourite(
    private val repository: DrinkRepository
) {
    operator fun invoke(value: Int, id: Int): Flow<Int> {
        return repository.updateFavourite(value, id)
    }
}