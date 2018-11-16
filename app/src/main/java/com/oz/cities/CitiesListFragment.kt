package com.oz.cities

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.cities_list_fragment.*

class CitiesListFragment : Fragment() {

    private val dummyCities = listOf(
        City("Donetsk", 922_137L),
        City("Kiev", 2_934_522L),
        City("Moscow", 12_506_468L)
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.cities_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(recyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = CityAdapter(dummyCities) { city ->
                Log.d("blablabla", "selected city ${city.name}")
            }
        }
    }

}