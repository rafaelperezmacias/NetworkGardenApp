package com.rpm.networkgardenapp.di

import com.rpm.networkgardenapp.data.local.PokemonDao
import com.rpm.networkgardenapp.data.remote.PokemonApi
import com.rpm.networkgardenapp.data.repository.PokemonRepositoryImpl
import com.rpm.networkgardenapp.domain.repository.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun providePokemonRepository(
        pokemonDao: PokemonDao,
        pokemonApi: PokemonApi
    ): PokemonRepository {
        return PokemonRepositoryImpl(pokemonDao, pokemonApi)
    }

}