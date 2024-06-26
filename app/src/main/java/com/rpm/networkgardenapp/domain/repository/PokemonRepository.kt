package com.rpm.networkgardenapp.domain.repository

import com.rpm.networkgardenapp.domain.model.Pokemon

interface PokemonRepository {

    suspend fun fetchPokemonList(): List<Pokemon>

    suspend fun insertPokemonList(pokemonList: List<Pokemon>)

    suspend fun getPokemonList(): List<Pokemon>

}