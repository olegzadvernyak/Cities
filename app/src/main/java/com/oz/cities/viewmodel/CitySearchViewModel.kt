package com.oz.cities.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.oz.cities.data.City
import com.oz.cities.db

class CitySearchViewModel : ViewModel() {

    private val _query = MutableLiveData<String>()

    val cities: LiveData<List<City>> = Transformations.switchMap(_query) { query ->
        db.cityDao().search("%$query%")
    }

    fun setQuery(query: String) {
        _query.postValue(query)
    }

    fun clearSearch() {
        _query.postValue("")
    }

}