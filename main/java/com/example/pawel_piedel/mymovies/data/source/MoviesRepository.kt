package com.example.pawel_piedel.mymovies.data.source

import com.example.pawel_piedel.mymovies.data.model.Movie
import com.example.pawel_piedel.mymovies.data.source.remote.MoviesRemoteDataSource
import io.reactivex.Observable

/**
 * Created by Pawel_Piedel on 30.10.2017.
 */
class MoviesRepository(val moviesRemoteDataSource: MoviesRemoteDataSource) : MoviesDataSource {
    
    override fun getMovieDetails(id: String, apiKey: String): Observable<Movie> {
        return moviesRemoteDataSource.getMovieDetails(id, apiKey)
    }

}