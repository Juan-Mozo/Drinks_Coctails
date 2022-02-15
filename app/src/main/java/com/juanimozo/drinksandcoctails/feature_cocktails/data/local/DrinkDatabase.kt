package com.juanimozo.drinksandcoctails.feature_cocktails.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Drink::class],
    version = 1
)
abstract class DrinkDatabase: RoomDatabase() {

    abstract val dao: DrinkDao

}