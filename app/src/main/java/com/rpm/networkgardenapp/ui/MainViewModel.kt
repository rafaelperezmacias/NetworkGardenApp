package com.rpm.networkgardenapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rpm.networkgardenapp.domain.model.Pokemon
import com.rpm.networkgardenapp.domain.usecase.GetAllPokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllPokemonUseCase: GetAllPokemonUseCase
) : ViewModel () {

    private val _pokemonList: MutableLiveData<List<Pokemon>> = MutableLiveData()
    val pokemonList: LiveData<List<Pokemon>>
        get() = _pokemonList

    fun getAllPokemon() {
        viewModelScope.launch {
            val pokemonList = getAllPokemonUseCase()
            _pokemonList.value = pokemonList
        }
    }

}