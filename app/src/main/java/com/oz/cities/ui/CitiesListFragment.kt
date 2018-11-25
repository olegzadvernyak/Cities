package com.oz.cities.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.oz.cities.data.City
import com.oz.cities.R
import kotlinx.android.synthetic.main.cities_list_fragment.*

private const val ARG_CITIES_SET = "ARG_CITIES_SET"

class CitiesListFragment : Fragment() {

    private val dummyCities0 = listOf(
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
        )
    )

    private val dummyCities1 = listOf(
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
        )
    )

    private val dummyCities2 = listOf(
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
            adapter = CityAdapter { city ->
                Log.d("blablabla", "selected city ${city.name}")
            }.apply {
                setCities(dummyCities)
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