package com.example.pawel_piedel.mymovies.data.model.model

import com.google.gson.annotations.SerializedName
import io.requery.Entity
import io.requery.Key
import io.requery.Persistable

/**
 * Created by Pawel_Piedel on 29.10.2017.
 */
@Entity
data class ProductionCompany(
        @SerializedName("name") val name: String, //Warner Bros.
        @get:Key @SerializedName("id") val id: Int //6194
) : Persistable