package com.example.android.networkconnect.data.datasource

import com.example.android.networkconnect.data.RickAndMortyModels
import com.example.android.networkconnect.data.services.RickAndMortyService
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CharaceterDataSource {
    private val client = OkHttpClient.Builder().build()

    companion object {
        const val RICK_AND_MORTY_BASE_URL = "https://rickandmortyapi.com/api/"
        const val CHARACTER_END_POINT = "character"
    }

    private fun getRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(RICK_AND_MORTY_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    private val service: RickAndMortyService = getRetrofitInstance().create(RickAndMortyService::class.java)

    suspend fun getCharacterList(): Response<RickAndMortyModels> =
        service.getRickAndMortyCharactersList(CHARACTER_END_POINT)
}
