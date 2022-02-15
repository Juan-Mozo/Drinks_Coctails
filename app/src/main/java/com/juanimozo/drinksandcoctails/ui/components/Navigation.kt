package com.juanimozo.drinksandcoctails.ui.components

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.juanimozo.drinksandcoctails.feature_cocktails.presentation.drinks.DrinkDetails
import com.juanimozo.drinksandcoctails.feature_cocktails.presentation.drinks.DrinksScreen
import com.juanimozo.drinksandcoctails.feature_cocktails.presentation.favourite_drinks.components.FavouritesScreen
import com.juanimozo.drinksandcoctails.ui.components.bottom_nav.BottomNavigationItem

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavigationItem.Drinks.route
    ) {
        composable(BottomNavigationItem.Drinks.route) {
            DrinksScreen(navController)
        }
        composable(
            route = Screen.DrinkDetails.route + "/{drinkId}/{drinkImage}",
            arguments = listOf(
                navArgument("drinkId") {
                    type = NavType.IntType
                    defaultValue = 1
                },
                navArgument("drinkImage") {
                    type = NavType.IntType
                    defaultValue = 1
                }
            )
        ) { entry ->
            DrinkDetails(
                drinkId = entry.arguments!!.getInt("drinkId"),
                drinkImage = entry.arguments!!.getInt("drinkImage")
            )
        }
        composable(BottomNavigationItem.Favourites.route) {
            FavouritesScreen(navController)
        }
    }
}