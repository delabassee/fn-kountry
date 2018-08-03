package com.fn.example.jackson

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.delabassee.Country

fun filterCountry(filter: String): List<Country> = when {
    filter.isNullOrEmpty() -> (Country.getAll())
    else -> {
        val allCountry = Country.getAll()
        val filteredCountry = allCountry.filter { it.name.contains(filter.trim(), true) }
        if (filteredCountry.isEmpty()) allCountry
        else filteredCountry
    }
}

// function entry point
fun country(input: String): String {
    val filteredCountry = filterCountry(input)
    return jacksonObjectMapper().writeValueAsString(filteredCountry)
}