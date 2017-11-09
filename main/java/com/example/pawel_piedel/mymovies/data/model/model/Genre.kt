package com.example.pawel_piedel.mymovies.data.model.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Pawel_Piedel on 29.10.2017.
 */
data class Genre(
        @SerializedName("id") val id: Int, //80
        @SerializedName("name") val name: String //Crime
)