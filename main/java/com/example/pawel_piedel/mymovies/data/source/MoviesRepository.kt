package com.example.pawel_piedel.mymovies.data.source

import com.example.pawel_piedel.mymovies.data.model.Movie
import com.example.pawel_piedel.mymovies.data.model.MoviesResponse
import com.example.pawel_piedel.mymovies.data.source.remote.RemoteDataSource
import io.reactivex.Flowable

/**
 * Created by Pawel_Piedel on 30.10.2017.
 */
class MoviesRepository(private val remoteDataSource: MoviesDataSource) : MoviesDataSource {

    override fun getTopRatedMovies(): Flowable<MoviesResponse> {
        return remoteDataSource.getTopRatedMovies()
    }

    override fun getUpcomingMovies(): Flowable<MoviesResponse> {
        return remoteDataSource.getUpcomingMovies()
    }

    override fun getPopularMovies(): Flowable<MoviesResponse> {
        return remoteDataSource.getPopularMovies()
    }

    override fun getMovieDetails(id: String): Flowable<Movie> {
        return remoteDataSource.getMovieDetails(id)
    }

}