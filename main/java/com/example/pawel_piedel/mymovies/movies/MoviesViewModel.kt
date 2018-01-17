package com.example.pawel_piedel.mymovies.movies

import android.Manifest
import android.util.Log
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
    var topRatedPage = 1
    var popularPage = 1
    var upcomingPage = 1
    var nowPlaying = 1

    val loadingIndicator: BehaviorSubject<Boolean> = BehaviorSubject.create()

    fun loadMoreMovies(moviesCategory: MoviesCategory): Flowable<List<Movie>> {
        Timber.d("Load more movies : " + moviesCategory.name)
        return when (moviesCategory) {
            MoviesCategory.POPULAR -> {
                loadPopularMovies(popularPage)
            }

            MoviesCategory.TOP_RATED -> {
                loadTopRatedMovies(topRatedPage)
            }
            MoviesCategory.UPCOMING -> {
                loadUpcomingMovies(upcomingPage)
            }
            MoviesCategory.NOW_PLAYING -> {
                loadNowPlayingMovies(nowPlaying)
            }
            else -> {
                Flowable.empty<List<Movie>>()
            }
        }
    }

    fun loadPopularMovies(page: Int = popularPage): Flowable<List<Movie>> = moviesRepository.getMovies(MoviesCategory.POPULAR, page)
            .doOnSubscribe { _ -> loadingIndicator.onNext(true) }
            .doOnNext { popularPage++ }
            .doOnNext { Log.d("POPULAR, page : ", "" + popularPage) }
            .doOnNext { _ -> loadingIndicator.onNext(false) }
            .doOnError { _ -> loadingIndicator.onNext(false) }


    fun loadTopRatedMovies(page: Int = topRatedPage): Flowable<List<Movie>> = moviesRepository.getMovies(MoviesCategory.TOP_RATED, page)
            .doOnSubscribe { _ -> loadingIndicator.onNext(true) }
            .doOnNext { _ -> loadingIndicator.onNext(false) }
            .doOnNext { topRatedPage++ }
            .doOnError { _ -> loadingIndicator.onNext(false) }

    fun loadUpcomingMovies(page: Int = upcomingPage): Flowable<List<Movie>> = moviesRepository.getMovies(MoviesCategory.UPCOMING, page)
            .doOnSubscribe { _ -> loadingIndicator.onNext(true) }
            .doOnNext { _ -> loadingIndicator.onNext(false) }
            .doOnNext { upcomingPage++ }
            .doOnError { _ -> loadingIndicator.onNext(false) }

    fun loadNowPlayingMovies(page: Int = nowPlaying): Flowable<List<Movie>> = moviesRepository.getMovies(MoviesCategory.NOW_PLAYING, page)
            .doOnSubscribe { _ -> loadingIndicator.onNext(true) }
            .doOnNext { _ -> loadingIndicator.onNext(false) }
            .doOnNext { nowPlaying++ }
            .doOnError { _ -> loadingIndicator.onNext(false) }

    fun onPermissionsAvailable(rxPermissions: RxPermissions) =
            rxPermissions
                    .request(Manifest.permission.INTERNET)


}