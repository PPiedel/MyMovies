package com.example.pawel_piedel.mymovies.data.source

import com.example.pawel_piedel.mymovies.data.model.Movie
import com.example.pawel_piedel.mymovies.data.model.MoviesResponse
import io.reactivex.Flowable
import io.reactivex.Observable

/**
 * Created by Pawel_Piedel on 30.10.2017.
 */
interface MoviesDataSource {
    fun getMovieDetails(id: String, apiKey: String) : Flowable<Movie>

    fun getTopRatedMovies(apiKey: String) : Flowable<MoviesResponse>

    fun getUpcomingMovies(apiKey: String) : Flowable<MoviesResponse>

    fun getPopularMovies(apiKey: String) : Flowable<MoviesResponse>
}