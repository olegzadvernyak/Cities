package com.oz.cities.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(cities: List<City>)

    @Query("select * from cities where name like :query")
    fun search(query: String): LiveData<List<City>>

}