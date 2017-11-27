package com.example.pawel_piedel.mymovies.data.model.model

import com.google.gson.annotations.SerializedName
import io.requery.Entity
import io.requery.Key
import io.requery.ManyToMany
import io.requery.Persistable

/**
 * Created by Pawel_Piedel on 29.10.2017.
 */
@Entity
data class Movie(
        @get:Key @SerializedName("id") val id: Int, //521
        @ManyToMany @SerializedName("genres") val genres: List<Genre>,
        @ManyToMany @SerializedName("production_companies") val productionCompanies: List<ProductionCompany>,
        @ManyToMany @SerializedName("production_countries") val productionCountries: List<ProductionCountry>,
        @ManyToMany @SerializedName("spoken_languages") val spokenLanguages: List<SpokenLanguage>,

        @SerializedName("adult") val adult: Boolean, //false
        @SerializedName("backdrop_path") val backdropPath: String, ///kmSrCmhF3mB15woqQ7z3Y4UGRwr.jpg
        @SerializedName("budget") val budget: Int, //1400000
        @SerializedName("homepage") val homepage: String,
        @SerializedName("imdb_id") val imdbId: String, //tt0046912
        @SerializedName("original_language") val originalLanguage: String, //en
        @SerializedName("original_title") val originalTitle: String, //Dial M for Murder
        @SerializedName("overview") val overview: String, //An ex-tennis pro carries out a plot to have his wife murdered after discovering she is having an affair, and assumes she will soon leave him for the other man anyway. When things go wrong, he improvises a new plan - to frame her for murder instead.
        @SerializedName("popularity") val popularity: Double, //9.272631
        @SerializedName("poster_path") val posterPath: String, ///xrpK1PyckNWmRxU4kZURfaCyboS.jpg
        @SerializedName("release_date") val releaseDate: String, //1954-05-29
        @SerializedName("revenue") val revenue: Int, //3000000
        @SerializedName("runtime") val runtime: Int, //104
        @SerializedName("status") val status: String, //Released
        @SerializedName("tagline") val tagline: String, //If a woman answers...hang on for dear life!
        @SerializedName("title") val title: String, //Dial M for Murder
        @SerializedName("video") val video: Boolean, //false
        @SerializedName("vote_average") val voteAverage: Double, //7.9
        @SerializedName("vote_count") val voteCount: Int, //556
        val category: MoviesCategory
) : Persistable
