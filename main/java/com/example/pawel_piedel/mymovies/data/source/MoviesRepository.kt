package com.example.pawel_piedel.mymovies.data.source

import com.example.pawel_piedel.mymovies.data.model.Movie
import com.example.pawel_piedel.mymovies.data.model.MoviesResponse
import com.example.pawel_piedel.mymovies.data.source.remote.RemoteDataSource
import io.reactivex.Flowable

/**
 * Created by Pawel_Piedel on 30.10.2017.
 */
class MoviesRepository(private val remoteDataSource: RemoteDataSource) : MoviesDataSource {

    override fun getTopRatedMovies(apiKey: String): Flowable<MoviesResponse> {
        return remoteDataSource.getTopRatedMovies(apiKey)
    }

    override fun getUpcomingMovies(apiKey: String): Flowable<MoviesResponse> {
        return remoteDataSource.getUpcomingMovies(apiKey)
    }

    override fun getPopularMovies(apiKey: String): Flowable<MoviesResponse> {
        return remoteDataSource.getPopularMovies(apiKey)
    }

    override fun getMovieDetails(id: String, apiKey: String): Flowable<Movie> {
        return remoteDataSource.getMovieDetails(id, apiKey)
    }

}