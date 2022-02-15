package com.juanimozo.drinksandcoctails.feature_cocktails.domain.util

sealed class DrinkOrder(val orderType: OrderType) {
    class Name(orderType: OrderType): DrinkOrder(orderType)
    class Popularity(orderType: OrderType): DrinkOrder(orderType)
}