package com.oz.cities.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.oz.cities.R
import kotlinx.android.synthetic.main.cities_list_activity.*

class CitiesListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cities_list_activity)

        viewPager.adapter = CitiesPagerAdapter(supportFragmentManager)
    }

}