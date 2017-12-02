package com.example.pawel_piedel.mymovies.data.source.remote

import com.example.pawel_piedel.mymovies.data.model.model.Movie
import com.example.pawel_piedel.mymovies.data.model.model.MoviesCategory
import com.example.pawel_piedel.mymovies.data.model.model.MoviesResponse
import com.example.pawel_piedel.mymovies.data.source.MoviesDataSource
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Pawel_Piedel on 30.10.2017.
 */
class RemoteSource @Inject
constructor(private val apiService: ApiService) : RemoteDataSource {

    override fun getMovies(moviesCategory: MoviesCategory): Flowable<MoviesResponse> {
        return when (moviesCategory) {
            MoviesCategory.TOP_RATED -> getTopRatedMovies()
            MoviesCategory.POPULAR -> getPopularMovies()
            MoviesCategory.UPCOMING -> getUpcomingMovies()
            else -> {
                Flowable.empty<MoviesResponse>()
            }
        }
    }


    private fun getTopRatedMovies(): Flowable<MoviesResponse> {
        return apiService.getTopRatedMovies()
    }

    private fun getUpcomingMovies(): Flowable<MoviesResponse> {
        return apiService.getUpcomingMovies()
    }

    private fun getPopularMovies(): Flowable<MoviesResponse> {
        return apiService.getPopularMovies()
    }

    override fun getMovieDetails(id: Int): Single<Movie> {
        return apiService.getMovieDetails(id)
    }
}