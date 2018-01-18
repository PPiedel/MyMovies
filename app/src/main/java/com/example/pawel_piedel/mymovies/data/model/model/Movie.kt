package com.example.pawel_piedel.mymovies.data.model.model

import com.google.gson.annotations.SerializedName
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by Pawel_Piedel on 29.10.2017.
 */
open class Movie(
        @PrimaryKey @SerializedName("id") var id: Int = 0,
        @SerializedName("production_companies") var productionCompanies: RealmList<ProductionCompany> = RealmList<ProductionCompany>(),
        @SerializedName("production_countries") var productionCountries: RealmList<ProductionCountry> = RealmList<ProductionCountry>(),
        @SerializedName("genres") var genres: RealmList<Genre> = RealmList<Genre>(),
        @SerializedName("spoken_languages") var spokenLanguages: RealmList<SpokenLanguage>? = RealmList<SpokenLanguage>(),
        @SerializedName("adult") var adult: Boolean? = false,
        @SerializedName("backdrop_path") var backdropPath: String? = "",
        @SerializedName("belongs_to_collection") var belongsToCollection: Collection? = null,
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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Movie

        if (id != other.id) return false
        if (productionCompanies != other.productionCompanies) return false
        if (productionCountries != other.productionCountries) return false
        if (genres != other.genres) return false
        if (spokenLanguages != other.spokenLanguages) return false
        if (adult != other.adult) return false
        if (backdropPath != other.backdropPath) return false
        if (belongsToCollection != other.belongsToCollection) return false
        if (budget != other.budget) return false
        if (homepage != other.homepage) return false
        if (imdbId != other.imdbId) return false
        if (originalLanguage != other.originalLanguage) return false
        if (originalTitle != other.originalTitle) return false
        if (overview != other.overview) return false
        if (popularity != other.popularity) return false
        if (posterPath != other.posterPath) return false
        if (releaseDate != other.releaseDate) return false
        if (revenue != other.revenue) return false
        if (runtime != other.runtime) return false
        if (status != other.status) return false
        if (tagline != other.tagline) return false
        if (title != other.title) return false
        if (video != other.video) return false
        if (voteAverage != other.voteAverage) return false
        if (voteCount != other.voteCount) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id ?: 0
        result = 31 * result + (productionCompanies.hashCode() ?: 0)
        result = 31 * result + (productionCountries.hashCode() ?: 0)
        result = 31 * result + (genres.hashCode() ?: 0)
        result = 31 * result + (spokenLanguages?.hashCode() ?: 0)
        result = 31 * result + (adult?.hashCode() ?: 0)
        result = 31 * result + (backdropPath?.hashCode() ?: 0)
        result = 31 * result + (belongsToCollection?.hashCode() ?: 0)
        result = 31 * result + (budget ?: 0)
        result = 31 * result + (homepage?.hashCode() ?: 0)
        result = 31 * result + (imdbId?.hashCode() ?: 0)
        result = 31 * result + (originalLanguage?.hashCode() ?: 0)
        result = 31 * result + (originalTitle?.hashCode() ?: 0)
        result = 31 * result + (overview?.hashCode() ?: 0)
        result = 31 * result + (popularity?.hashCode() ?: 0)
        result = 31 * result + (posterPath?.hashCode() ?: 0)
        result = 31 * result + (releaseDate?.hashCode() ?: 0)
        result = 31 * result + (revenue ?: 0)
        result = 31 * result + (runtime ?: 0)
        result = 31 * result + (status?.hashCode() ?: 0)
        result = 31 * result + (tagline?.hashCode() ?: 0)
        result = 31 * result + (title?.hashCode() ?: 0)
        result = 31 * result + (video?.hashCode() ?: 0)
        result = 31 * result + (voteAverage?.hashCode() ?: 0)
        result = 31 * result + (voteCount ?: 0)
        return result
    }


}