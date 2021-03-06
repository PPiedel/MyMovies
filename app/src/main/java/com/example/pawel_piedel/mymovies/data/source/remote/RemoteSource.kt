package com.example.pawel_piedel.mymovies.data.source.remote

import com.example.pawel_piedel.mymovies.data.model.model.Movie
import com.example.pawel_piedel.mymovies.data.model.model.MoviesCategory
import com.example.pawel_piedel.mymovies.data.model.model.MoviesResponse
import io.reactivex.Flowable
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by Pawel_Piedel on 30.10.2017.
 */
class RemoteSource @Inject
constructor(private val apiService: ApiService) : RemoteDataSource {

    override fun loadSearchResults(query: String) : Flowable<MoviesResponse> {
        return apiService.searchMovies(query)
    }

    override fun getMovies(moviesCategory: MoviesCategory, page: Int): Flowable<MoviesResponse> {
        Timber.d("Metoda getMovies ")
        return when (moviesCategory) {
            MoviesCategory.TOP_RATED -> getTopRatedMovies(page)
            MoviesCategory.POPULAR -> getPopularMovies(page)
            MoviesCategory.UPCOMING -> getUpcomingMovies(page)
            MoviesCategory.NOW_PLAYING -> getNowPlayingMovies(page)
            else -> {
                Flowable.empty<MoviesResponse>()
            }
        }
    }


    fun getTopRatedMovies(page: Int): Flowable<MoviesResponse> {
        return apiService.getTopRatedMovies(page)
    }

    fun getUpcomingMovies(page: Int): Flowable<MoviesResponse> {
        return apiService.getUpcomingMovies(page)
    }

    fun getPopularMovies(page: Int): Flowable<MoviesResponse> {
        Timber.d("getPopularMovies")
        return apiService.getPopularMovies(page)
    }

    fun getNowPlayingMovies(page: Int): Flowable<MoviesResponse> {
        return apiService.getNowPlayingMovies(page)
    }

    override fun getMovieDetails(id: Int): Flowable<Movie> {
        return apiService.getMovieDetails(id)
    }
}