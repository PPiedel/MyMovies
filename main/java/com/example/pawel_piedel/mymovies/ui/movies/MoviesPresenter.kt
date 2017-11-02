package com.example.pawel_piedel.mymovies.ui.movies

import android.util.Log
import com.example.pawel_piedel.mymovies.data.model.MoviesCategory
import com.example.pawel_piedel.mymovies.data.model.MoviesResponse
import com.example.pawel_piedel.mymovies.data.source.MoviesDataSource
import com.example.pawel_piedel.mymovies.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


/**
 * Created by Pawel_Piedel on 30.10.2017.
 */
class MoviesPresenter @Inject
constructor(val moviesDataSource: MoviesDataSource) : BasePresenter<MoviesContract.View>(), MoviesContract.Presenter {

    override fun loadMovies(moviesCategory: MoviesCategory) {
        when (moviesCategory) {
            MoviesCategory.TOP_RATED -> moviesDataSource.getTopRatedMovies()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnNext { t: MoviesResponse ->  Log.d(LOG_TAG,t.results.toString()) }
                    .subscribe { movieResponse -> view?.showMovies(movieResponse.results) }

            MoviesCategory.UPCOMING -> moviesDataSource.getUpcomingMovies()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnNext { t: MoviesResponse ->  Log.d(LOG_TAG,t.results.toString()) }
                    .subscribe { movieResponse -> view?.showMovies(movieResponse.results) }

            MoviesCategory.POPULAR -> moviesDataSource.getPopularMovies()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnNext { t: MoviesResponse ->  Log.d(LOG_TAG,t.results.toString()) }
                    .subscribe { movieResponse -> view?.showMovies(movieResponse.results) }

        }

    }


    companion object {
        val LOG_TAG = MoviesPresenter::class.java.simpleName
    }
}