package com.example.pawel_piedel.mymovies.movies

import android.Manifest
import com.example.pawel_piedel.mymovies.data.model.model.Movie
import com.example.pawel_piedel.mymovies.data.model.model.MoviesCategory
import com.example.pawel_piedel.mymovies.data.source.MoviesRepository
import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.Flowable
import io.reactivex.subjects.BehaviorSubject
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by Pawel_Piedel on 05.11.2017.
 */
class MoviesViewModel @Inject
constructor(private val moviesRepository: MoviesRepository) {

    val loadingIndicator: BehaviorSubject<Boolean> = BehaviorSubject.create()

    fun loadMovies(moviesCategory: MoviesCategory, page: Int = 1): Flowable<List<Movie>> {
        Timber.d("Load more movies : " + moviesCategory.name)
        return when (moviesCategory) {
            MoviesCategory.POPULAR -> {
                loadPopularMovies(page)
            }
            MoviesCategory.TOP_RATED -> {
                loadTopRatedMovies(page)
            }
            MoviesCategory.UPCOMING -> {
                loadUpcomingMovies(page)
            }
            MoviesCategory.NOW_PLAYING -> {
                loadNowPlayingMovies(page)
            }
            else -> {
                Flowable.empty<List<Movie>>()
            }
        }

    }

    fun loadPopularMovies(page: Int): Flowable<List<Movie>> = moviesRepository.getMovies(MoviesCategory.POPULAR, page)
                    .doOnSubscribe { _ -> loadingIndicator.onNext(true) }
                    .doOnNext { _ -> loadingIndicator.onNext(false) }
                    .doOnError { _ -> loadingIndicator.onNext(false) }
                    .doOnComplete { loadingIndicator.onNext(false) }


    fun loadTopRatedMovies(page: Int): Flowable<List<Movie>> = moviesRepository.getMovies(MoviesCategory.TOP_RATED, page)
            .doOnSubscribe { _ -> loadingIndicator.onNext(true) }
            .doOnNext { _ -> loadingIndicator.onNext(false) }
            .doOnError { _ -> loadingIndicator.onNext(false) }
            .doOnComplete { loadingIndicator.onNext(false) }

    fun loadUpcomingMovies(page: Int): Flowable<List<Movie>> = moviesRepository.getMovies(MoviesCategory.UPCOMING, page)
            .doOnSubscribe { _ -> loadingIndicator.onNext(true) }
            .doOnNext { _ -> loadingIndicator.onNext(false) }
            .doOnError { _ -> loadingIndicator.onNext(false) }
            .doOnComplete { loadingIndicator.onNext(false) }

    fun loadNowPlayingMovies(page: Int): Flowable<List<Movie>> = moviesRepository.getMovies(MoviesCategory.NOW_PLAYING, page)
            .doOnSubscribe { _ -> loadingIndicator.onNext(true) }
            .doOnNext { _ -> loadingIndicator.onNext(false) }
            .doOnError { _ -> loadingIndicator.onNext(false) }
            .doOnComplete { loadingIndicator.onNext(false) }

    fun onPermissionsAvailable(rxPermissions: RxPermissions) = rxPermissions
                    .request(Manifest.permission.INTERNET)


}