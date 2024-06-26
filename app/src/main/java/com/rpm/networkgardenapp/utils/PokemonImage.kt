package com.rpm.networkgardenapp.utils

class PokemonImage {

    companion object {

        fun getPokemonImage(url: String): String {
            val pokemonId = url.replace("/", "")
                .removePrefix("https:pokeapi.coapiv2pokemon")
            return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$pokemonId.png"
        }

    }

}