package com.example.pawel_piedel.mymovies.data.model.model

import com.google.gson.annotations.SerializedName
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by Pawel_Piedel on 29.10.2017.
 */
open class Movie(
        @PrimaryKey @SerializedName("id") var id: Int? = 0,
        @SerializedName("production_companies") var productionCompanies: RealmList<ProductionCompany?>? = RealmList(),
        @SerializedName("production_countries") var productionCountries: RealmList<ProductionCountry?>? = RealmList(),
        @SerializedName("genres") var genres: RealmList<Genre?>? = RealmList(),
        @SerializedName("spoken_languages") var spokenLanguages: RealmList<SpokenLanguage?>? = RealmList(),
        @SerializedName("adult") var adult: Boolean? = false,
        @SerializedName("backdrop_path") var backdropPath: String? = "",
        @SerializedName("belongs_to_collection") var belongsToCollection: Collection? = Collection(),
        @SerializedName("budget") var budget: Int? = 0,
        @SerializedName("homepage") var homepage: String? = "",
        @SerializedName("imdb_id") var imdbId: String? = "",
        @SerializedName("original_language") var originalLanguage: String? = "",
        @SerializedName("original_title") var originalTitle: String? = "",
        @SerializedName("overview") var overview: String? = "",
        @SerializedName("popularity") var popularity: Double? = 0.0,
        @SerializedName("poster_path") var posterPath: String? = "",
        @SerializedName("release_date") var releaseDate: String? = "",
        @SerializedName("revenue") var revenue: Int? = 0,
        @SerializedName("runtime") var runtime: Int? = 0,
        @SerializedName("status") var status: String? = "",
        @SerializedName("tagline") var tagline: String? = "",
        @SerializedName("title") var title: String? = "",
        @SerializedName("video") var video: Boolean? = false,
        @SerializedName("vote_average") var voteAverage: Double? = 0.0,
        @SerializedName("vote_count") var voteCount: Int? = 0
) : RealmObject() {
    override fun toString(): String {
        return "Movie(id=$id, productionCompanies=$productionCompanies, productionCountries=$productionCountries, genres=$genres, spokenLanguages=$spokenLanguages, adult=$adult, backdropPath=$backdropPath, belongsToCollection=$belongsToCollection, budget=$budget, homepage=$homepage, imdbId=$imdbId, originalLanguage=$originalLanguage, originalTitle=$originalTitle, overview=$overview, popularity=$popularity, posterPath=$posterPath, releaseDate=$releaseDate, revenue=$revenue, runtime=$runtime, status=$status, tagline=$tagline, title=$title, video=$video, voteAverage=$voteAverage, voteCount=$voteCount)"
    }
}