package com.example.pawel_piedel.mymovies.data.model.model

import com.google.gson.annotations.SerializedName
import io.realm.RealmObject

/**
 * Created by Pawel_Piedel on 29.10.2017.
 */
open class ProductionCountry(
        @SerializedName("iso_3166_1") var iso31661: String? = "",
        @SerializedName("name") var name: String? = ""
): RealmObject()