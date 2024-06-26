package com.rpm.networkgardenapp.data.remote

import com.google.gson.annotations.SerializedName

data class PokemonDto(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)