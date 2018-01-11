package com.example.pawel_piedel.mymovies.local

import com.example.pawel_piedel.mymovies.data.model.model.Movie
import com.example.pawel_piedel.mymovies.data.model.model.MoviesCategory
import com.example.pawel_piedel.mymovies.data.model.model.MoviesResponse
import io.reactivex.Single

/**
 * Created by Pawel_Piedel on 25.11.2017.
 */

interface LocalDataSource {
    fun getMovies(moviesCategory: MoviesCategory, page: Int): List<Movie>

    fun getMovieDetails(id: Int): Single<Movie>

    fun saveMoviesResponse(moviesResponse: MoviesResponse)
}
