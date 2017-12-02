package com.example.pawel_piedel.mymovies.data.model.model

import com.google.gson.annotations.SerializedName
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey


/**
 * Created by Pawel_Piedel on 30.10.2017.
 */

open class MoviesResponse(
        @SerializedName("page") var page: Int = 0,
        @SerializedName("total_results") var totalResults: Int = 0,
        @SerializedName("total_pages") var totalPages: Int = 0,
        @SerializedName("results") var results: RealmList<Movie> = RealmList(),
        var category: String = MoviesCategory.DEFAULT.name,
        @PrimaryKey var id: Int = 0
) : RealmObject()

