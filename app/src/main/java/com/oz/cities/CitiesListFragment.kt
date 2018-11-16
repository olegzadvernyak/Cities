package com.oz.cities

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.cities_list_fragment.*

private const val ARG_CITIES_SET = "ARG_CITIES_SET"

class CitiesListFragment : Fragment() {

    private val dummyCities0 = listOf(
        City("Donetsk", 922_137L),
        City("Kiev", 2_934_522L),
        City("Moscow", 12_506_468L)
    )

    private val dummyCities1 = listOf(
        City("New York City", 8_175_133L),
        City("San Jose", 1_015_785L),
        City("Los Angeles", 3_976_322L)
    )

    private val dummyCities2 = listOf(
        City("London", 8_825_000L),
        City("Liverpool", 864_122L),
        City("Nottingham", 729_977L)
    )

    private lateinit var dummyCities: List<City>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dummyCities = when(arguments?.get(ARG_CITIES_SET)) {
            1 -> dummyCities1
            2 -> dummyCities2
            else -> dummyCities0
        }
    }

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

    companion object {

        fun newInstance(citiesSet: Int): CitiesListFragment {
            return CitiesListFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_CITIES_SET, citiesSet)
                }
            }
        }

    }

}