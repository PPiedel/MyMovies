package com.example.pawel_piedel.mymovies.data.model.model

import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey


/**
 * Created by Pawel_Piedel on 23.11.2017.
 */

open class Collection(
        @PrimaryKey @SerializedName("id") var id: Int? = 0,
        @SerializedName("name") var name: String? = "",
        @SerializedName("poster_path") var posterPath: String? = "",
        @SerializedName("backdrop_path") var backdropPath: String? = ""
) : RealmObject()