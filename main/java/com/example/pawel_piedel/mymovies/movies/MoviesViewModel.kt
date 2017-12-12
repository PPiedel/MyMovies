package com.example.pawel_piedel.mymovies.movies

import com.example.pawel_piedel.mymovies.data.model.model.Movie
import com.example.pawel_piedel.mymovies.data.model.model.MoviesCategory
import com.example.pawel_piedel.mymovies.data.source.MoviesRepository
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import org.intellij.lang.annotations.Flow
import timber.log.Timber
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

    fun loadMoreMovies(moviesCategory: MoviesCategory): Observable<List<Movie>> {
        Timber.d("Load more movies : " + moviesCategory.name)
        return when (moviesCategory) {
            MoviesCategory.POPULAR -> {
                popularPage++
                loadPopularMovies(popularPage)
            }

            MoviesCategory.TOP_RATED -> {
                topRatedPage++
                loadTopRatedMovies(topRatedPage)
            }
            MoviesCategory.UPCOMING -> {
                upcomingPage++
                loadUpcomingMovies(upcomingPage)
            }
            else -> {
                Observable.empty<List<Movie>>()
            }
        }
    }

    fun loadPopularMovies(page: Int = popularPage): Observable<List<Movie>> = moviesRepository.getMovies(MoviesCategory.POPULAR, page)
            .doOnSubscribe { _ -> loadingIndicator.onNext(true) }
            .doOnNext { _ -> loadingIndicator.onNext(false) }
            .doOnError { _ -> loadingIndicator.onNext(false) }


    fun loadTopRatedMovies(page: Int = topRatedPage): Observable<List<Movie>> = moviesRepository.getMovies(MoviesCategory.TOP_RATED, page)
            .doOnSubscribe { _ -> loadingIndicator.onNext(true) }
            .doOnNext { _ -> loadingIndicator.onNext(false) }
            .doOnError { _ -> loadingIndicator.onNext(false) }

    fun loadUpcomingMovies(page: Int = upcomingPage): Observable<List<Movie>> = moviesRepository.getMovies(MoviesCategory.UPCOMING, page)
            .doOnSubscribe { _ -> loadingIndicator.onNext(true) }
            .doOnNext { _ -> loadingIndicator.onNext(false) }
            .doOnError { _ -> loadingIndicator.onNext(false) }


}