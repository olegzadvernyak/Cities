package com.oz.cities

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

typealias ItemClickListener<T> = (T) -> Unit

class CityAdapter(
    private val cities: List<City>,
    private val itemClickListener: ItemClickListener<City>
) : RecyclerView.Adapter<CityViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        return CityViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.city_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return cities.size
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.bind(cities[position], itemClickListener)
    }

}