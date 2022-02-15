package com.juanimozo.drinksandcoctails.feature_cocktails.data.local

import androidx.room.Dao
import androidx.room.Query

@Dao
interface DrinkDao {

    @Query("SELECT * FROM drink WHERE language = 'English'")
    suspend fun getDrinks(): List<Drink>

    // Search drink by user input
    @Query("SELECT * FROM drink WHERE name LIKE '%' || :drinkSearch || '%'")
    suspend fun searchDrink(drinkSearch: String): List<Drink>

    // Update favourite status by id. If value = 0 then it's false, if value = 1 then it's true
    @Query("UPDATE drink SET favourite = :value WHERE id = :id")
    suspend fun updateFavourite(value: Int, id: Int)

    // Get a list of favourite drinks
    @Query("SELECT * FROM drink WHERE favourite = 1")
    suspend fun getFavouriteDrinks(): List<Drink>

    // Get Drink by Id
    @Query("SELECT * FROM drink WHERE id = :id")
    suspend fun getDrinkById(id: Int): Drink

}