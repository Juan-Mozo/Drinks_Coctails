package com.juanimozo.drinksandcoctails.feature_cocktails.data.repository

import com.juanimozo.drinksandcoctails.feature_cocktails.data.local.DrinkDao
import com.juanimozo.drinksandcoctails.feature_cocktails.domain.model.DrinkModel
import com.juanimozo.drinksandcoctails.feature_cocktails.domain.repository.DrinkRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class DrinkRepositoryImpl(
    private val dao: DrinkDao
): DrinkRepository {

    override fun getDrinks(): Flow<List<DrinkModel>> = flow {
        val drinkList = dao.getDrinks().map { it.toDrinkModel() }
        emit(drinkList)
    }

    override fun searchDrink(drinkSearch: String): Flow<List<DrinkModel>> = flow {
        val drink = dao.searchDrink(drinkSearch).map { it.toDrinkModel() }
        emit(drink)
    }

    override fun updateFavourite(value: Int, id: Int): Flow<Int> = flow {
        dao.updateFavourite(value, id)
    }

    override fun getFavouriteDrinks(): Flow<List<DrinkModel>> = flow {
        val drinkList = dao.getFavouriteDrinks().map { it.toDrinkModel() }
        emit(drinkList)
    }

    override fun getDrinkById(id: Int): Flow<DrinkModel> = flow {
        val drink = dao.getDrinkById(id).toDrinkModel()
        emit(drink)
    }

}