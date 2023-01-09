package com.example.android.networkconnect.data.services

import com.example.android.networkconnect.data.RickAndMortyModels
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RickAndMortyService {

    @GET("{url}")
    suspend fun getRickAndMortyCharactersList(
        @Path(value = "url", encoded = true) url: String
    ): Response<RickAndMortyModels>
}
