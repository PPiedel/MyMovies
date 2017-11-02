package com.example.pawel_piedel.mymovies.data.source

import com.example.pawel_piedel.mymovies.data.model.Movie
import com.example.pawel_piedel.mymovies.data.model.MoviesResponse
import io.reactivex.Flowable
import io.reactivex.Observable

/**
 * Created by Pawel_Piedel on 30.10.2017.
 */
interface MoviesDataSource {
    fun getMovieDetails(id: String) : Flowable<Movie>

    fun getTopRatedMovies() : Flowable<MoviesResponse>

    fun getUpcomingMovies() : Flowable<MoviesResponse>

    fun getPopularMovies() : Flowable<MoviesResponse>
}