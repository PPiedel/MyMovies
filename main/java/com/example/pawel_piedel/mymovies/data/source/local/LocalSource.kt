package com.example.pawel_piedel.mymovies.data.source.local

import com.example.pawel_piedel.mymovies.data.model.model.Movie
import com.example.pawel_piedel.mymovies.data.model.model.MoviesCategory
import com.example.pawel_piedel.mymovies.data.model.model.MoviesResponse
import io.reactivex.Single
import io.realm.Realm
import timber.log.Timber
import javax.inject.Inject


/**
 * Created by Pawel_Piedel on 29.11.2017.
 */

class LocalSource @Inject
constructor(val realm: Realm) : LocalDataSource {

    override fun saveMoviesResponse(moviesResponse: MoviesResponse) {
        realm.executeTransaction {
            realm.copyToRealmOrUpdate(moviesResponse)
        }
    }


    override fun getMovies(moviesCategory: MoviesCategory, page: Int): List<Movie> {
        val movies = realm.where(MoviesResponse::class.java).equalTo(MoviesResponse::category.name, moviesCategory.name).and().equalTo(MoviesResponse::page.name, page).findFirst()
        return movies?.results ?: emptyList<Movie>()
    }


    override fun getMovieDetails(id: Int): Single<Movie> {
        val movie = realm.where(Movie::class.java).like(Movie::id.name, id.toString()).findFirst()
        return Single.just(movie)
    }
}