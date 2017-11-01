package com.example.pawel_piedel.mymovies.ui.movies

import com.example.pawel_piedel.mymovies.data.model.MoviesCategory
import com.example.pawel_piedel.mymovies.data.source.MoviesDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


/**
 * Created by Pawel_Piedel on 30.10.2017.
 */
class MoviesPresenter @Inject
constructor(val moviesDataSource: MoviesDataSource) : MoviesContract.Presenter {

    private var view: MoviesContract.View? = null
    private val disposables: CompositeDisposable = CompositeDisposable()

    fun attachView(view: MoviesContract.View) {
        this.view = view
    }

    fun detachView() {
        this.view = null
    }


    fun clearSubscriptions() {
        disposables.clear()
    }

    override fun loadMovies(moviesCategory: MoviesCategory) {
        when (moviesCategory) {
            MoviesCategory.TOP_RATED -> loadTopRatedMovies()
            MoviesCategory.UPCOMING -> loadUpcomingMovies()
            MoviesCategory.POPULAR -> loadPopularMovies()
        }
    }

    private fun loadTopRatedMovies() {
        disposables.add(moviesDataSource.getTopRatedMovies("111")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { movieResponse -> view!!.show(movieResponse.results) })
    }

    private fun loadUpcomingMovies() {
        disposables.add(moviesDataSource.getUpcomingMovies("111")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { moviesResponse -> view!!.show(moviesResponse.results) })
    }

    private fun loadPopularMovies() {
        disposables.add(moviesDataSource.getPopularMovies("111")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { moviesResponse -> view!!.show(moviesResponse.results) })
    }

}