package com.example.pawel_piedel.mymovies.movies

import com.example.pawel_piedel.mymovies.data.model.model.MoviesCategory
import com.example.pawel_piedel.mymovies.data.source.MoviesRepository
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

/**
 * Created by Pawel_Piedel on 05.11.2017.
 */
class MoviesViewModel @Inject
constructor(private val moviesRepository: MoviesRepository) {
    var topRatedPage = 1
    var popularPage = 1
    var upcomingPage = 1

    val loadingIndicator: BehaviorSubject<Boolean> = BehaviorSubject.create()

    fun loadPopularMovies() = moviesRepository.getMovies(MoviesCategory.POPULAR, popularPage)

    fun loadTopRatedMovies() = moviesRepository.getMovies(MoviesCategory.TOP_RATED, topRatedPage)

    fun loadUpcomingMovies() = moviesRepository.getMovies(MoviesCategory.UPCOMING, upcomingPage)


}