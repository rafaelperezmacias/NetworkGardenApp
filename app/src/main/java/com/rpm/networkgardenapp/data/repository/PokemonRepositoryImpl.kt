package com.rpm.networkgardenapp.data.repository

import com.rpm.networkgardenapp.data.local.PokemonDao
import com.rpm.networkgardenapp.data.mapper.PokemonMapper
import com.rpm.networkgardenapp.data.remote.PokemonApi
import com.rpm.networkgardenapp.domain.model.Pokemon
import com.rpm.networkgardenapp.domain.repository.PokemonRepository
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val pokemonDao: PokemonDao,
    private val pokemonApi: PokemonApi
) : PokemonRepository {

    override suspend fun fetchPokemonList(): List<Pokemon> {
        return try {
            val request = pokemonApi.fetchFirstGeneration()

            if ( request.isSuccessful ) {
                val pokemonMapper = PokemonMapper()
                request.body()?.results?.map { pokemonMapper.fromDTOToDomain(it) } ?: emptyList()
            } else {
                emptyList()
            }
        } catch ( ex: Exception ) {
            emptyList()
        }
    }

    override suspend fun insertPokemonList(pokemonList: List<Pokemon>) {
        val pokemonMapper = PokemonMapper()
        pokemonDao.insertAllPokemon(
            *pokemonList.map { pokemonMapper.fromDomainToEntity(it) }.toTypedArray()
        )
    }

    override suspend fun getPokemonList(): List<Pokemon> {
        val pokemonMapper = PokemonMapper()
        return pokemonDao.getAllPokemon().map { pokemonMapper.fromEntityToDomain(it) }
    }

}