package com.oz.cities.ui

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oz.cities.R
import com.oz.cities.viewmodel.CitySearchViewModel
import kotlinx.android.synthetic.main.city_search_fragment.*

class CitySearchFragment : Fragment() {

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(CitySearchViewModel::class.java)
    }
    private var cityAdapter: CityAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.city_search_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (activity as? AppCompatActivity)?.setSupportActionBar(toolbar)

        cityAdapter = CityAdapter()
        with(recyclerView) {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = cityAdapter
        }

        viewModel.cities.observe(this, Observer { cities ->
            cityAdapter?.setCities(cities)
        })
        viewModel.clearSearch()
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.city_search_toolbar_menu, menu)
        (menu?.findItem(R.id.action_search)?.actionView as? SearchView)?.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    if (newText.isNullOrBlank()) viewModel.clearSearch() else viewModel.setQuery(newText)
                    return true
                }
            })
    }

    companion object {

        fun newInstance(): CitySearchFragment {
            return CitySearchFragment()
        }

    }

}