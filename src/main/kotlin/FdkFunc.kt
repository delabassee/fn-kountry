package com.fn.example.fdk

import com.delabassee.Country

fun country(input: String): List<Country> = when {
    input.isNullOrEmpty() -> (Country.getAll())
    else -> {
        val allCountry = Country.getAll()
        val filteredCountry = allCountry.filter { it.name.contains(input.trim(), true) }
        if (filteredCountry.isEmpty()) allCountry
        else filteredCountry
    }
}