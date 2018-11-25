package com.oz.cities.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.oz.cities.GlideApp
import com.oz.cities.R
import com.oz.cities.data.City
import kotlinx.android.synthetic.main.city_item.view.*

class CityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(city: City, itemClickListener: ItemClickListener<City>?) {
        with(itemView) {
            nameTextView.text = city.name
            populationTextView.text = city.population.toString()
            GlideApp.with(this)
                .load(city.emblemUrl)
                .placeholder(R.drawable.ic_city)
                .into(emblemImageView)
            setOnClickListener { itemClickListener?.invoke(city) }
        }
    }

}