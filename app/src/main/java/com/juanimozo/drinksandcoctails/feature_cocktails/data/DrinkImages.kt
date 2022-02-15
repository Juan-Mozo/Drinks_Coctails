package com.juanimozo.drinksandcoctails.feature_cocktails.data

import com.juanimozo.drinksandcoctails.R

val drinkImagesMap = mapOf<String, Int>(
    "Americano" to R.drawable.americano,
    "Aperol Spritz" to R.drawable.aperol_spritz,
    "Bloody Mary" to R.drawable.bloody_mary,
    "Cosmopolitan" to R.drawable.cosmopolitan,
    "Daiquiri" to R.drawable.daiquiri,
    "Dry Martini" to R.drawable.dry_martini,
    "Manhattan" to R.drawable.manhattan,
    "Negroni" to R.drawable.negroni,
    "Old Fashioned" to R.drawable.old_fashioned,
    "Piña Colada" to R.drawable.pina_colada,
    "Tom Collins" to R.drawable.tom_collins,
    "Mojito" to R.drawable.caipirinha,
    "Caipirinha" to R.drawable.caipirinha,
    "Long Island Iced Tea" to R.drawable.long_island_iced_tea,
    "Margarita" to R.drawable.margarita,
    "Mararita" to R.drawable.margarita
)

fun getImage(key: String): Int {
    return drinkImagesMap.getValue(key)
}