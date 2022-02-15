package com.juanimozo.drinksandcoctails.feature_cocktails.presentation.drinks

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juanimozo.drinksandcoctails.feature_cocktails.domain.model.DrinkModel
import com.juanimozo.drinksandcoctails.feature_cocktails.domain.use_case.DrinkUseCases
import com.juanimozo.drinksandcoctails.feature_cocktails.domain.util.DrinkOrder
import com.juanimozo.drinksandcoctails.feature_cocktails.domain.util.OrderType
import com.juanimozo.drinksandcoctails.feature_cocktails.presentation.favourite_drinks.FavouriteDrinksState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DrinksViewModel @Inject constructor(
    private val drinkUseCases: DrinkUseCases
): ViewModel() {

    private val _searchQuery = mutableStateOf("")
    val searchQuery: State<String> = _searchQuery

    private val _currentDrink = mutableStateOf(DrinkState())
    val currentDrink: State<DrinkState> = _currentDrink

    private val _state = mutableStateOf(DrinksState())
    val state: State<DrinksState> = _state

    private val _favouriteState = mutableStateOf(FavouriteDrinksState())
    val favouriteState: State<FavouriteDrinksState> = _favouriteState

    init {
        getDrinks(DrinkOrder.Name(OrderType.Ascending))
    }

    private var getFavouriteJob: Job? = null
    private var updateFavouriteJob: Job? = null
    private var searchJob: Job? = null
    private var getDrinkJob: Job? = null
    private var getDrinksJob: Job? = null

    fun onEvent(event: DrinksEvent) {
        when (event) {
            is DrinksEvent.Order -> {
                if (state.value.drinkOrder::class == event.drinkOrder::class &&
                    state.value.drinkOrder.orderType == event.drinkOrder.orderType
                ) {
                    return
                }
                getDrinks(event.drinkOrder)
            }
            is DrinksEvent.MakeFavourite -> {
                viewModelScope.launch {
                    drinkUseCases.updateFavourite(1, event.drink.id)
                    _currentDrink.value = currentDrink.value.copy(
                        isFavourite = true
                    )
                }
            }
            is DrinksEvent.UndoFavourite -> {
                viewModelScope.launch {
                    drinkUseCases.updateFavourite(0, event.drink.id)
                    _currentDrink.value = currentDrink.value.copy(
                        isFavourite = false
                    )
                }
            }
            is DrinksEvent.ToggleOrderSection -> {
                _state.value = state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )
            }
        }
    }

    fun updateFavourite(value: Int, drinkId: Int) {
        when (value) {
            0 -> {
                _currentDrink.value = currentDrink.value.copy(
                    isFavourite = false
                )
            }
            1 -> {
                _currentDrink.value = currentDrink.value.copy(
                    isFavourite = true
                )
            }
        }
        updateFavouriteJob?.cancel()
        updateFavouriteJob = drinkUseCases.updateFavourite(value, drinkId).launchIn(viewModelScope)
    }

    fun onSearch(query: String) {
        _searchQuery.value = query
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            delay(500L)
            val searchedDrinks = drinkUseCases.searchDrink(query)
            searchedDrinks
                .onEach { drinks ->
                    _state.value = state.value.copy(
                        drinks = drinks
                    )
                }
                .launchIn(viewModelScope)
        }
    }

    fun getDrink(id: Int) {
        getDrinkJob?.cancel()
        getDrinkJob = drinkUseCases.getDrink(id)
            .onEach { newDrink ->
                _currentDrink.value = currentDrink.value.copy(
                    drink = DrinkModel(
                        id = newDrink.id,
                        name = newDrink.name,
                        description = newDrink.description,
                        ingredient = newDrink.ingredient,
                        recipe = newDrink.recipe,
                        category = newDrink.category,
                        popularity = newDrink.popularity,
                        language = newDrink.language,
                        favourite = newDrink.favourite
                    )
                )
            }
            .launchIn(viewModelScope)
    }

    private fun getDrinks(drinkOrder: DrinkOrder) {
        getDrinksJob?.cancel()
        getDrinksJob = drinkUseCases.getDrinks(drinkOrder)
            .onEach { drinks ->
                _state.value = state.value.copy(
                    drinks = drinks,
                    drinkOrder = drinkOrder
                )
            }
            .launchIn(viewModelScope)
    }

    fun getFavouriteDrinks() {
        getFavouriteJob?.cancel()
        getFavouriteJob = drinkUseCases.getFavouriteDrinks()
            .onEach { drinks ->
                _favouriteState.value = favouriteState.value.copy(
                    drinks = drinks
                )
            }
            .launchIn(viewModelScope)
    }

}