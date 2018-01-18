package com.example.pawel_piedel.mymovies.data.source

import com.example.pawel_piedel.mymovies.data.model.model.Movie
import com.example.pawel_piedel.mymovies.data.model.model.MoviesCategory
import com.example.pawel_piedel.mymovies.data.model.model.MoviesResponse
import io.reactivex.Flowable
import io.reactivex.Observable

/**
 * Created by Pawel_Piedel on 30.10.2017.
 */
interface MoviesDataSource {
    fun getMovieDetails(id: Int): Flowable<Movie>

    fun getMovies(moviesCategory: MoviesCategory, page: Int): Flowable<List<Movie>>

}