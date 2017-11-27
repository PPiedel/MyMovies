package com.example.pawel_piedel.mymovies.data.model.model

import com.google.gson.annotations.SerializedName
import io.requery.Entity
import io.requery.Key
import io.requery.Persistable


/**
 * Created by Pawel_Piedel on 23.11.2017.
 */
@Entity
data class MovieCollection(
        @get:Key @SerializedName("id") val id: Int, //10
        @SerializedName("name") val name: String, //Star Wars MovieCollection
        @SerializedName("poster_path") val posterPath: String, ///ghd5zOQnDaDW1mxO7R5fXXpZMu.jpg
        @SerializedName("backdrop_path") val backdropPath: String ///d8duYyyC9J5T825Hg7grmaabfxQ.jpg
) : Persistable