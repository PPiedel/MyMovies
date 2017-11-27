package com.example.pawel_piedel.mymovies.data.model.model

import com.google.gson.annotations.SerializedName
import io.requery.Entity
import io.requery.Key
import io.requery.Persistable

/**
 * Created by Pawel_Piedel on 29.10.2017.
 */
@Entity
data class SpokenLanguage(
        @get:Key @SerializedName("iso_639_1") val iso6391: String, //en
        @SerializedName("name") val name: String //English
) : Persistable