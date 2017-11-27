package com.example.pawel_piedel.mymovies.data.source.local

import com.example.pawel_piedel.mymovies.data.model.model.Movie
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Maybe

/**
 * Created by Pawel_Piedel on 27.11.2017.
 */
interface LocalDataSource {

    fun saveMovies(movies: List<Movie>): Completable

    fun findMovieById(id: String): Maybe<Movie>

    fun getTopRatedMovies(): Flowable<Movie>

    fun getUpcomingMovies(): Flowable<Movie>

    fun getPopularMovies(): Flowable<Movie>
}