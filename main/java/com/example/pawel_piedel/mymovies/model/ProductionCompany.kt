package com.example.pawel_piedel.mymovies.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Pawel_Piedel on 29.10.2017.
 */
data class ProductionCompany(
        @SerializedName("name") val name: String, //Warner Bros.
        @SerializedName("id") val id: Int //6194
)