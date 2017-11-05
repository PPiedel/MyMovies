package com.example.pawel_piedel.mymovies.ui.movies

import com.example.pawel_piedel.mymovies.data.model.MoviesResponse
import com.example.pawel_piedel.mymovies.data.source.MoviesDataSource
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by Pawel_Piedel on 05.11.2017.
 */
class MoviesViewModel @Inject
constructor(private val moviesDataSource: MoviesDataSource) {

    fun loadPopularMovies(): Flowable<MoviesResponse> {
        return moviesDataSource.getPopularMovies()
    }

    fun loadTopRatedMovies(): Flowable<MoviesResponse> {
        return moviesDataSource.getTopRatedMovies()
    }

    fun loadUpcomingMovies(): Flowable<MoviesResponse> {
        return moviesDataSource.getUpcomingMovies()
    }


}