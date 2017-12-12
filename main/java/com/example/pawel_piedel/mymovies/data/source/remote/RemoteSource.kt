package com.example.pawel_piedel.mymovies.data.source.remote

import com.example.pawel_piedel.mymovies.data.model.model.Movie
import com.example.pawel_piedel.mymovies.data.model.model.MoviesCategory
import com.example.pawel_piedel.mymovies.data.model.model.MoviesResponse
import io.reactivex.Observable
import io.reactivex.Single
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by Pawel_Piedel on 30.10.2017.
 */
class RemoteSource @Inject
constructor(private val apiService: ApiService) : RemoteDataSource {

    override fun getMovies(moviesCategory: MoviesCategory, page: Int): Observable<MoviesResponse> {
        Timber.d("Metoda getMovies ")
        return when (moviesCategory) {
            MoviesCategory.TOP_RATED -> getTopRatedMovies(page)
            MoviesCategory.POPULAR -> getPopularMovies(page)
            MoviesCategory.UPCOMING -> getUpcomingMovies(page)
            else -> {
                Observable.empty<MoviesResponse>()
            }
        }
    }


    fun getTopRatedMovies(page: Int): Observable<MoviesResponse> {
        return apiService.getTopRatedMovies(page)
    }

    fun getUpcomingMovies(page: Int): Observable<MoviesResponse> {
        return apiService.getUpcomingMovies(page)
    }

    fun getPopularMovies(page: Int): Observable<MoviesResponse> {
        Timber.d("getPopularMovies")
        return apiService.getPopularMovies(page)
    }

    override fun getMovieDetails(id: Int): Single<Movie> {
        return apiService.getMovieDetails(id)
    }
}