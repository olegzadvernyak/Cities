package com.oz.cities.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(version = 1, entities = [
    City::class
])
abstract class CitiesDatabase : RoomDatabase() {

    abstract fun cityDao(): CityDao

}