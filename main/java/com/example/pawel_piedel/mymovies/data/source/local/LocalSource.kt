package com.example.pawel_piedel.mymovies.data.source.local

import android.util.Log
import com.example.pawel_piedel.mymovies.data.model.model.Movie
import com.example.pawel_piedel.mymovies.data.model.model.MoviesCategory
import com.example.pawel_piedel.mymovies.data.model.model.MoviesResponse
import io.reactivex.Single
import io.reactivex.subjects.BehaviorSubject
import io.realm.Realm
import javax.inject.Inject


/**
 * Created by Pawel_Piedel on 29.11.2017.
 */

class LocalSource @Inject
constructor(val realm: Realm) : LocalDataSource {

    val realmTransaction: BehaviorSubject<Boolean> = BehaviorSubject.create()

    override fun saveMoviesResponse(moviesResponse: MoviesResponse) {
        val realm = Realm.getDefaultInstance()
        realm.executeTransaction { transactionRealm ->
            transactionRealm.copyToRealmOrUpdate(moviesResponse)

        }
        realm.close()
    }


    override fun getMovies(moviesCategory: MoviesCategory, page: Int): List<Movie> {
        Log.d("Log", "Jestem w getMovies")
        return realm.where(MoviesResponse::class.java).findAll().flatMap { moviesResponse -> moviesResponse.results }.toList()
    }


    override fun getMovieDetails(id: Int): Single<Movie> {
        val movie = realm.where(Movie::class.java).like(Movie::id.name, id.toString()).findFirst()
        return Single.just(movie)
    }
}