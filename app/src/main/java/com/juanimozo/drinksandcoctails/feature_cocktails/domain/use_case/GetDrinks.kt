package com.juanimozo.drinksandcoctails.feature_cocktails.domain.use_case

import com.juanimozo.drinksandcoctails.feature_cocktails.domain.model.DrinkModel
import com.juanimozo.drinksandcoctails.feature_cocktails.domain.repository.DrinkRepository
import com.juanimozo.drinksandcoctails.feature_cocktails.domain.util.DrinkOrder
import com.juanimozo.drinksandcoctails.feature_cocktails.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetDrinks(
    private val repository: DrinkRepository
) {
    operator fun invoke(
        drinkOrder: DrinkOrder = DrinkOrder.Name(OrderType.Descending)
    ): Flow<List<DrinkModel>> {
        return repository.getDrinks().map { drinks ->
            when(drinkOrder.orderType) {
                is OrderType.Ascending -> {
                    when(drinkOrder) {
                        is DrinkOrder.Name -> drinks.sortedBy {it.name}
                        is DrinkOrder.Popularity -> drinks.sortedBy { it.popularity }
                    }
                }
                is OrderType.Descending -> {
                    when(drinkOrder) {
                        is DrinkOrder.Name -> drinks.sortedByDescending { it.name }
                        is DrinkOrder.Popularity -> drinks.sortedByDescending { it.popularity }
                    }
                }
            }
        }
    }
}