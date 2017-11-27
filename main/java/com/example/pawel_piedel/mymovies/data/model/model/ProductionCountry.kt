package com.example.pawel_piedel.mymovies.data.model.model

import com.google.gson.annotations.SerializedName
import io.requery.Entity
import io.requery.Key
import io.requery.Persistable

/**
 * Created by Pawel_Piedel on 29.10.2017.
 */
@Entity
data class ProductionCountry(
        @get:Key @SerializedName("iso_3166_1") val iso31661: String, //US
        @SerializedName("name") val name: String //United States of America
) : Persistable