package com.example.pawel_piedel.mymovies.data.source.remote

import com.example.pawel_piedel.mymovies.data.model.model.Movie
import com.example.pawel_piedel.mymovies.data.model.model.MoviesCategory
import com.example.pawel_piedel.mymovies.data.model.model.MoviesResponse
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by Pawel_Piedel on 29.11.2017.
 */
interface RemoteDataSource {
    fun getMovies(moviesCategory: MoviesCategory, page : Int): Observable<MoviesResponse>

    fun  getMovieDetails(id: Int): Single<Movie>
}