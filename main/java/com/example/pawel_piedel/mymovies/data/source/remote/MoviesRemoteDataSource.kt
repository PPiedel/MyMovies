package com.example.pawel_piedel.mymovies.data.source.remote

import com.example.pawel_piedel.mymovies.data.model.Movie
import com.example.pawel_piedel.mymovies.data.source.MoviesDataSource
import io.reactivex.Observable

/**
 * Created by Pawel_Piedel on 30.10.2017.
 */
class MoviesRemoteDataSource : MoviesDataSource {
    val tmdbApiService by lazy {
        TmdbApiService.create()
    }

    override fun getMovieDetails(id: String, apiKey: String): Observable<Movie> {
        return tmdbApiService.getMovieDetails(id, apiKey)
    }


}