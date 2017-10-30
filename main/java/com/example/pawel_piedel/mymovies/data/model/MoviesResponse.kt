package com.example.pawel_piedel.mymovies.data.model
import com.google.gson.annotations.SerializedName


/**
 * Created by Pawel_Piedel on 30.10.2017.
 */

data class MoviesResponse(
        @SerializedName("page") val page: Int, //1
        @SerializedName("total_results") val totalResults: Int, //7180
        @SerializedName("total_pages") val totalPages: Int, //359
        @SerializedName("results") val results: List<Movie>
)

