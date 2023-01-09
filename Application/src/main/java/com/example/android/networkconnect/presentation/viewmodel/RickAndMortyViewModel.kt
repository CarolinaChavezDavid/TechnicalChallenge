package com.example.android.networkconnect.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.networkconnect.data.RickAndMortyModels
import com.example.android.networkconnect.data.repository.RickAndMortyRepository
import kotlinx.coroutines.launch

class RickAndMortyViewModel : ViewModel() {
    private val repository = RickAndMortyRepository()

    private val _charactersLiveData = MutableLiveData<RickAndMortyModels>()
    val charactersLiveData: LiveData<RickAndMortyModels> = _charactersLiveData

    fun loadInfo() {
        viewModelScope.launch {
            val response = repository.getCharactersList()
            response.let {
                _charactersLiveData.postValue(it)
            }
        }
    }
}
