package com.example.pawel_piedel.mymovies.data.model.model

import com.google.gson.annotations.SerializedName


/**
 * Created by Pawel_Piedel on 23.11.2017.
 */

data class Collection(
        @SerializedName("id") var id: Int? = 0, //10
        @SerializedName("name") var name: String? = "", //Star Wars Collection
        @SerializedName("poster_path") var posterPath: String? = "", ///ghd5zOQnDaDW1mxO7R5fXXpZMu.jpg
        @SerializedName("backdrop_path") var backdropPath: String? = "" ///d8duYyyC9J5T825Hg7grmaabfxQ.jpg
)