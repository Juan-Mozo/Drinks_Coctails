package com.juanimozo.drinksandcoctails.ui.components.bottom_nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigationItem(val route: String, var icon: ImageVector, val title: String) {
    object Drinks : BottomNavigationItem("drinks", Icons.Default.Home, "Drinks")
    object Favourites : BottomNavigationItem("favourites", Icons.Default.Favorite, "Favourites")
//    object MyDrinks : BottomNavigationItem("mydrinks", Icons.Default.Face, "My Drinks")
}
