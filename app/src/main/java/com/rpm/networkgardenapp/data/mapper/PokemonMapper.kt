package com.rpm.networkgardenapp.data.mapper

import com.rpm.networkgardenapp.data.local.PokemonEntity
import com.rpm.networkgardenapp.data.remote.PokemonDto
import com.rpm.networkgardenapp.domain.model.Pokemon

class PokemonMapper {

    fun fromDTOToDomain(pokemonDTO: PokemonDto): Pokemon {
        return Pokemon(name = pokemonDTO.name, url = pokemonDTO.url)
    }

    fun fromDomainToDTO(pokemon: Pokemon): PokemonDto {
        return PokemonDto(name = pokemon.name, url = pokemon.url)
    }

    fun fromDomainToEntity(pokemon: Pokemon): PokemonEntity {
        return PokemonEntity(name = pokemon.name, url = pokemon.url)
    }

    fun fromEntityToDomain(pokemonEntity: PokemonEntity): Pokemon {
        return Pokemon(name = pokemonEntity.name, url = pokemonEntity.url)
    }

}