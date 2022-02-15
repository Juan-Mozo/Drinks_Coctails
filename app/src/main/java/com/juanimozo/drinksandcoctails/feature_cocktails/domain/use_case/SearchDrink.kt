package com.juanimozo.drinksandcoctails.feature_cocktails.domain.use_case

import com.juanimozo.drinksandcoctails.feature_cocktails.domain.model.DrinkModel
import com.juanimozo.drinksandcoctails.feature_cocktails.domain.repository.DrinkRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchDrink(
    private val repository: DrinkRepository
) {

    operator fun invoke(drinkSearch: String): Flow<List<DrinkModel>> {
        if(drinkSearch.isBlank()) {
            return flow {  }
        }
        return repository.searchDrink(drinkSearch)
    }

}