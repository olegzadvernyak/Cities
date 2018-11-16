package com.oz.cities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.cities_list_activity.*

class CitiesListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cities_list_activity)

        viewPager.adapter = CitiesPagerAdapter(supportFragmentManager)
    }

}