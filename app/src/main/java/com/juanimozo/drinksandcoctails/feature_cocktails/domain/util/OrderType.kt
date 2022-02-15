package com.juanimozo.drinksandcoctails.feature_cocktails.domain.util

sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}
