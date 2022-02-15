package com.juanimozo.drinksandcoctails.feature_cocktails.presentation.drinks

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.juanimozo.drinksandcoctails.R
import com.juanimozo.drinksandcoctails.feature_cocktails.data.getImage
import com.juanimozo.drinksandcoctails.feature_cocktails.presentation.drinks.components.DrinkItem
import com.juanimozo.drinksandcoctails.feature_cocktails.presentation.drinks.components.OrderSection
import com.juanimozo.drinksandcoctails.ui.theme.*

@ExperimentalAnimationApi
@Composable
fun DrinksScreen(
    navController: NavController
) {
    val viewModel: DrinksViewModel = hiltViewModel()
    val state = viewModel.state.value

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(
                modifier = Modifier.padding(start = 4.dp, end = 4.dp, top = 5.dp),
                onClick = {
                    viewModel.onEvent(DrinksEvent.ToggleOrderSection)
                },
            ) {
                Icon(
                    imageVector = Icons.Outlined.Menu,
                    contentDescription = "Sort",
                    tint = DarkYellow
                )
            }
            // Search Bar
            TextField(
                value = viewModel.searchQuery.value,
                onValueChange = viewModel::onSearch,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Navy),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = TransparentNavy,
                    cursorColor = DarkBlue
                ),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Words,
                    keyboardType = KeyboardType.Text
                ),
                singleLine = true,
                placeholder = {
                    Text(
                        text = stringResource(R.string.search),
                        fontWeight = FontWeight.Light
                    )
                }
            )
        }
        AnimatedVisibility(
            visible = state.isOrderSectionVisible,
            enter = fadeIn() + slideInVertically(),
            exit = fadeOut() + slideOutVertically()
        ) {
            OrderSection(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
                    .background(Black.copy(0.3f)),
                drinkOrder = state.drinkOrder,
                onOrderChange = {
                    viewModel.onEvent(DrinksEvent.Order(it))
                }
            )
        }
        // Drinks List
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(state.drinks) { drink ->
                val drinkImage = getImage(drink.name)
                DrinkItem(
                    drink = drink,
                    drinkImage = drinkImage,
                    navController = navController
                )
            }
        }
    }
}