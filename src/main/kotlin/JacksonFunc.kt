package com.fn.example.jackson

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.delabassee.Country

fun country(input: String): String {
    return jacksonObjectMapper().writeValueAsString( listCountries(input) )
}

fun listCountries(input: String): List<Country> = when {
    input.isEmpty() -> Country.getAll()
    else -> Country.getAll().filteredOrAll {
        it.name.contains(input.trim(), true)
    }
}

private fun <T> List<T>.filteredOrAll(predicate: (T) -> Boolean): List<T> {
    val filtered = filter(predicate)
    return when {
        filtered.isEmpty() -> this
        else -> filtered
    }
}