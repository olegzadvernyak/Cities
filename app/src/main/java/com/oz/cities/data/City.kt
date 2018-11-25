package com.oz.cities.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cities")
data class City(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val name: String,
    val population: Long,
    @ColumnInfo(name = "emblem_url")
    val emblemUrl: String? = null
)