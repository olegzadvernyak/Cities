package com.oz.cities

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.oz.cities.data.CitiesDatabase
import com.oz.cities.data.City
import java.util.concurrent.Executors

// вот так лучше не делать. лучше использовать inversion of control в том или ином виде
// через dependency injection или service locator паттерны
lateinit var db: CitiesDatabase

class CitiesApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            this,
            CitiesDatabase::class.java,
            "cities_db"
        ).addCallback(object : RoomDatabase.Callback() {
            override fun onCreate(supportDb: SupportSQLiteDatabase) {
                // экзекуторы тоже можно пока игнорировать
                Executors.newSingleThreadExecutor().submit {
                    db.cityDao().insertAll(listOf(
                        City(
                            name = "Donetsk",
                            population = 922_137L,
                            emblemUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/8/81/Greater_Coat_of_Arms_of_Donetsk_%281995%29.svg/180px-Greater_Coat_of_Arms_of_Donetsk_%281995%29.svg.png"
                        ),
                        City(name = "Kiev", population = 2_934_522L),
                        City(
                            name = "Moscow",
                            population = 12_506_468L,
                            emblemUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/b/bb/Coat_of_Arms_of_Moscow.svg/180px-Coat_of_Arms_of_Moscow.svg.png"
                        ),
                        City(
                            name = "New York City",
                            population = 8_175_133L,
                            emblemUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/3/39/Seal_of_New_York_City.svg/180px-Seal_of_New_York_City.svg.png"
                        ),
                        City(
                            name = "San Jose",
                            population = 1_015_785L,
                            emblemUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/6/64/Blason_de_San_Jos%C3%A9_%28Costa_Rica%29.svg/180px-Blason_de_San_Jos%C3%A9_%28Costa_Rica%29.svg.png"
                        ),
                        City(
                            name = "Los Angeles",
                            population = 3_976_322L,
                            emblemUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/0/02/Seal_of_Los_Angeles%2C_California.svg/180px-Seal_of_Los_Angeles%2C_California.svg.png"
                        ),
                        City(
                            name = "London",
                            population = 8_825_000L,
                            emblemUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/2/20/Coat_of_Arms_of_The_City_of_London.svg/180px-Coat_of_Arms_of_The_City_of_London.svg.png"
                        ),
                        City(
                            name = "Liverpool",
                            population = 864_122L,
                            emblemUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/6/6d/Coat_of_arms_of_Liverpool_City_Council.png/180px-Coat_of_arms_of_Liverpool_City_Council.png"
                        ),
                        City(name = "Nottingham", population = 729_977L)
                    ))
                }
            }
        }).build()
    }

}