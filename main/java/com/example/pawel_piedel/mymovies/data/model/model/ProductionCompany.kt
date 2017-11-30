package com.example.pawel_piedel.mymovies.data.model.model

import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by Pawel_Piedel on 29.10.2017.
 */
open class ProductionCompany(
        @PrimaryKey @SerializedName("name") var name: String? = "",
        @SerializedName("id") var id: Int? = 0
) : RealmObject()