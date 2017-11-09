package com.example.pawel_piedel.mymovies.data.model.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Pawel_Piedel on 29.10.2017.
 */
data class ProductionCountry(
        @SerializedName("iso_3166_1") val iso31661: String, //US
        @SerializedName("name") val name: String //United States of America
)