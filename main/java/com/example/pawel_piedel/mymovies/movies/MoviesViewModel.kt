package com.example.pawel_piedel.mymovies.movies

import com.example.pawel_piedel.mymovies.data.model.model.MoviesResponse
import com.example.pawel_piedel.mymovies.data.source.MoviesRepository
import io.reactivex.Flowable
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

/**
 * Created by Pawel_Piedel on 05.11.2017.
 */
class MoviesViewModel @Inject
constructor(private val moviesRepository: MoviesRepository) {
    val loadingIndicator: BehaviorSubject<Boolean> = BehaviorSubject.create()

    fun loadPopularMovies(): Flowable<MoviesResponse> {
        return moviesRepository.getPopularMovies()
    }

    fun loadTopRatedMovies(): Flowable<MoviesResponse> {
        return moviesRepository.getTopRatedMovies()
    }

    fun loadUpcomingMovies(): Flowable<MoviesResponse> {
        return moviesRepository.getUpcomingMovies()
    }


}