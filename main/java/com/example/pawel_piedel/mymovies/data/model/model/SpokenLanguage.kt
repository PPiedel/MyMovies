package com.example.pawel_piedel.mymovies.data.model.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Pawel_Piedel on 29.10.2017.
 */
data class SpokenLanguage(
        @SerializedName("iso_639_1") val iso6391: String, //en
        @SerializedName("name") val name: String //English
)