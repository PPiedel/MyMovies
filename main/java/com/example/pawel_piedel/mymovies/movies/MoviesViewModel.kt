package com.example.pawel_piedel.mymovies.movies

import com.example.pawel_piedel.mymovies.data.model.model.MoviesCategory
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

    fun loadPopularMovies() = moviesRepository.getMovies(MoviesCategory.POPULAR)

    fun loadTopRatedMovies() = moviesRepository.getMovies(MoviesCategory.TOP_RATED)

    fun loadUpcomingMovies() = moviesRepository.getMovies(MoviesCategory.UPCOMING)


}