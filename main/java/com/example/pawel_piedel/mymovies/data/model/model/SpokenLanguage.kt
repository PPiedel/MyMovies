package com.example.pawel_piedel.mymovies.data.model.model

import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by Pawel_Piedel on 29.10.2017.
 */
open class SpokenLanguage(
        @PrimaryKey @SerializedName("iso_639_1") var iso6391: String? = "",
        @SerializedName("name") var name: String? = ""
) : RealmObject()