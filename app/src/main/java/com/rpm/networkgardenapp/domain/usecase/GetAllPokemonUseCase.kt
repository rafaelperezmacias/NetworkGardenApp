package com.rpm.networkgardenapp.domain.usecase

import com.rpm.networkgardenapp.domain.model.Pokemon
import com.rpm.networkgardenapp.domain.repository.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetAllPokemonUseCase @Inject constructor(
    private val repository: PokemonRepository
) {

    suspend operator fun invoke(): List<Pokemon> {
        return withContext(Dispatchers.IO) {
            val networkPokemonList = repository.fetchPokemonList()
            repository.insertPokemonList(networkPokemonList)
            repository.getPokemonList()
        }

    }

}