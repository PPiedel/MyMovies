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

    override fun getTopRatedMovies(): Flowable<MoviesResponse> {
        return apiService.getTopRatedMovies()
    }

    override fun getUpcomingMovies(): Flowable<MoviesResponse> {
        return apiService.getUpcomingMovies()
    }

    override fun getPopularMovies(): Flowable<MoviesResponse> {
        return apiService.getPopularMovies()
    }

    override fun getMovieDetails(id: String): Flowable<Movie> {
        return apiService.getMovieDetails(id)
    }


}