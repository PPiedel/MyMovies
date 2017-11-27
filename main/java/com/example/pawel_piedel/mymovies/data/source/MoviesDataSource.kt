package com.example.pawel_piedel.mymovies.data.source

import com.example.pawel_piedel.mymovies.data.model.model.Movie
import com.example.pawel_piedel.mymovies.data.model.model.MoviesCategory
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * Created by Pawel_Piedel on 27.11.2017.
 */
interface MoviesDataSource {

    fun getMovies(moviesCategory: MoviesCategory): Flowable<List<Movie>>

    fun getMovieDetails(id: String): Single<Movie>

}