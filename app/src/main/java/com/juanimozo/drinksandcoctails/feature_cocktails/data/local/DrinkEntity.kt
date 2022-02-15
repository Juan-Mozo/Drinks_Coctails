package com.juanimozo.drinksandcoctails.feature_cocktails.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.juanimozo.drinksandcoctails.feature_cocktails.domain.model.DrinkModel

@Entity
data class Drink(
    @PrimaryKey val Id: Int?,
    val Name: String?,
    val Description: String?,
    val Ingredient: String?,
    val Recipe: String?,
    val Category: String?,
    val Popularity: Int?,
    val Language: String?,
    val Favourite: Int?
) {
    fun toDrinkModel(): DrinkModel {
        return DrinkModel(
            id = Id!!,
            name = Name!!,
            description = Description!!,
            ingredient = Ingredient!!,
            recipe = Recipe!!,
            category = Category!!,
            popularity = Popularity!!,
            language = Language!!,
            favourite = Favourite!!
        )
    }
}
