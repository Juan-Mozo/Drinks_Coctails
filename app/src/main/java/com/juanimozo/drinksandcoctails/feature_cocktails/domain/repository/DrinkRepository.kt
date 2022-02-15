package com.juanimozo.drinksandcoctails.feature_cocktails.domain.repository

import com.juanimozo.drinksandcoctails.feature_cocktails.domain.model.DrinkModel
import kotlinx.coroutines.flow.Flow

interface DrinkRepository {

    fun getDrinks(): Flow<List<DrinkModel>>

    fun searchDrink(drinkSearch: String): Flow<List<DrinkModel>>

    fun updateFavourite(value: Int, id: Int): Flow<Int>

    fun getFavouriteDrinks(): Flow<List<DrinkModel>>

    fun getDrinkById(id: Int): Flow<DrinkModel>

}