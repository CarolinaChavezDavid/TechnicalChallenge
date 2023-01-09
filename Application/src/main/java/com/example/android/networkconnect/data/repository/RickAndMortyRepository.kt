package com.example.android.networkconnect.data.repository

import com.example.android.networkconnect.data.RickAndMortyModels
import com.example.android.networkconnect.data.datasource.CharaceterDataSource

class RickAndMortyRepository() {

    suspend fun getCharactersList(): RickAndMortyModels? {
        val request = CharaceterDataSource().getCharacterList()
        return if (request.isSuccessful) request.body() else null
    }
}
