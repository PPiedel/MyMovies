package com.example.pawel_piedel.mymovies.data.source.remote

import com.example.pawel_piedel.mymovies.data.model.model.Movie
import com.example.pawel_piedel.mymovies.data.model.model.MoviesCategory
import com.example.pawel_piedel.mymovies.data.model.model.MoviesResponse
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by Pawel_Piedel on 29.11.2017.
 */
interface RemoteDataSource {
    fun getMovies(moviesCategory: MoviesCategory, page : Int): Flowable<MoviesResponse>

    fun  getMovieDetails(id: Int): Flowable<Movie>

    fun loadSearchResults(query : String) : Flowable<MoviesResponse>
}