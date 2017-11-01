package com.example.pawel_piedel.mymovies.data.source.remote

import com.example.pawel_piedel.mymovies.data.model.Movie
import com.example.pawel_piedel.mymovies.data.model.MoviesResponse
import com.example.pawel_piedel.mymovies.data.source.MoviesDataSource
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by Pawel_Piedel on 30.10.2017.
 */
class RemoteDataSource @Inject
constructor(private val apiService: ApiService) : MoviesDataSource {

    override fun getTopRatedMovies(apiKey: String): Flowable<MoviesResponse> {
        return apiService.getTopRatedMovies(apiKey)
    }

    override fun getUpcomingMovies(apiKey: String): Flowable<MoviesResponse> {
        return apiService.getUpcomingMovies(apiKey)
    }

    override fun getPopularMovies(apiKey: String): Flowable<MoviesResponse> {
        return apiService.getPopularMovies(apiKey)
    }

    override fun getMovieDetails(id: String, apiKey: String): Flowable<Movie> {
        return apiService.getMovieDetails(id, apiKey)
    }


}