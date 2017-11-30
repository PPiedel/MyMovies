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

    override fun getMovies(moviesCategory: MoviesCategory): Flowable<List<Movie>> {
        return when (moviesCategory) {
            MoviesCategory.TOP_RATED -> getTopRatedMovies()
            MoviesCategory.POPULAR -> getPopularMovies()
            MoviesCategory.UPCOMING -> getUpcomingMovies()
            else -> {
                Flowable.empty<List<Movie>>()
            }
        }
    }


    private fun getTopRatedMovies(): Flowable<List<Movie>> {
        return apiService.getTopRatedMovies().map { t: MoviesResponse -> t.results }
    }

    private fun getUpcomingMovies(): Flowable<List<Movie>> {
        return apiService.getUpcomingMovies().map { t: MoviesResponse -> t.results }
    }

    private fun getPopularMovies(): Flowable<List<Movie>> {
        return apiService.getPopularMovies().map { t: MoviesResponse -> t.results }
    }

    override fun getMovieDetails(id: Int): Single<Movie> {
        return apiService.getMovieDetails(id)
    }
}