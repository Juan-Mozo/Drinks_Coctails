package com.juanimozo.drinksandcoctails.feature_cocktails.domain.model

data class DrinkModel(
    val id: Int,
    val name: String,
    val description: String,
    val ingredient: String,
    val recipe: String,
    val category: String,
    val popularity: Int,
    val language: String,
    val favourite: Int
)
