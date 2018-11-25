package com.oz.cities.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oz.cities.data.City
import com.oz.cities.R

typealias ItemClickListener<T> = (T) -> Unit

class CityAdapter(
    private val itemClickListener: ItemClickListener<City>? = null
) : RecyclerView.Adapter<CityViewHolder>() {

    private var cities: List<City>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        return CityViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.city_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return cities?.size ?: 0
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        cities?.get(position)?.let { city ->
            holder.bind(city, itemClickListener)
        }
    }

    fun setCities(cities: List<City>) {
        this.cities = cities
        notifyDataSetChanged()
    }

}