package com.oz.cities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class CitiesListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager
            .beginTransaction()
            .add(android.R.id.content, CitiesListFragment())
            .commit()
    }

}