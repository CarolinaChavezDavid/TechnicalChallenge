package com.example.android.networkconnect.data

import com.google.gson.annotations.SerializedName

data class RickAndMortyModels(
    @SerializedName("results")
    var characterList: List<CharacterInfoModel>
)

data class CharacterInfoModel(
    var id: Int,
    var name: String,
    var image: String
)
