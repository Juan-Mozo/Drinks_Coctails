package com.juanimozo.drinksandcoctails.di

import android.app.Application
import androidx.room.Room
import com.juanimozo.drinksandcoctails.feature_cocktails.data.local.DrinkDatabase
import com.juanimozo.drinksandcoctails.feature_cocktails.data.repository.DrinkRepositoryImpl
import com.juanimozo.drinksandcoctails.feature_cocktails.domain.repository.DrinkRepository
import com.juanimozo.drinksandcoctails.feature_cocktails.domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CocktailModule {

    @Provides
    @Singleton
    fun provideDrinkRepository(
        db: DrinkDatabase
    ): DrinkRepository {
        return DrinkRepositoryImpl(db.dao)
    }

    @Provides
    @Singleton
    fun provideDrinkDatabase(app: Application): DrinkDatabase {
        return Room.databaseBuilder(
            app, DrinkDatabase::class.java, "drink.db"
        )
            // Pre-populated database with recipes
            .createFromAsset("database/drink.db")
            .build()
    }

    @Provides
    @Singleton
    fun provideDrinkUseCases(repository: DrinkRepository): DrinkUseCases {
        return DrinkUseCases(
            getDrink = GetDrink(repository),
            getDrinks = GetDrinks(repository),
            getFavouriteDrinks = GetFavouriteDrinks(repository),
            searchDrink = SearchDrink(repository),
            updateFavourite = UpdateFavourite(repository)
        )
    }
}