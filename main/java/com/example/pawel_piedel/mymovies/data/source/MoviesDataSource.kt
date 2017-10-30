package com.example.pawel_piedel.mymovies.data.source

import com.example.pawel_piedel.mymovies.data.model.Movie
import io.reactivex.Observable

/**
 * Created by Pawel_Piedel on 30.10.2017.
 */
interface MoviesDataSource {
    fun getMovieDetails(id: String, apiKey: String) : Observable<Movie>
}