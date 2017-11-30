package com.example.pawel_piedel.mymovies.data.source.local

import com.example.pawel_piedel.mymovies.data.model.model.Movie
import com.example.pawel_piedel.mymovies.data.model.model.MoviesCategory
import com.example.pawel_piedel.mymovies.data.model.model.MoviesResponse
import com.example.pawel_piedel.mymovies.data.source.MoviesDataSource
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Pawel_Piedel on 25.11.2017.
 */

interface LocalDataSource {
    fun getMovies(moviesCategory: MoviesCategory): List<Movie>

    fun  getMovieDetails(id: Int): Single<Movie>

    fun saveMovies(movies : List<Movie>)
}
