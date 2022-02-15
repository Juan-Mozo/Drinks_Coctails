package com.juanimozo.drinksandcoctails

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.juanimozo.drinksandcoctails.feature_cocktails.presentation.drinks.DrinksScreen
import com.juanimozo.drinksandcoctails.ui.components.Navigation
import com.juanimozo.drinksandcoctails.ui.components.bottom_nav.BottomNavigationBar
import com.juanimozo.drinksandcoctails.ui.theme.DrinksCoctailsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DrinksCoctailsTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
//        topBar = { TobBar() },
        bottomBar = { BottomNavigationBar(navController) }
    ) {
        Navigation(navController)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DrinksCoctailsTheme {
        MainScreen()
    }
}