package com.juanimozo.drinksandcoctails.ui.components

sealed class Screen(val route: String) {
    object DrinkDetails: Screen("drink_details")

    fun withArgs(vararg args: Int): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
