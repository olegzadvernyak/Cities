package com.oz.cities

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.city_item.view.*

class CityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(city: City, itemClickListener: ItemClickListener<City>) {
        with(itemView) {
            nameTextView.text = city.name
            populationTextView.text = city.population.toString()
            setOnClickListener { itemClickListener.invoke(city) }
        }
    }

}