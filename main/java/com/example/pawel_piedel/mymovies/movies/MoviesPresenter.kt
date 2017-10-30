package com.example.pawel_piedel.mymovies.movies

import io.reactivex.disposables.Disposable


/**
 * Created by Pawel_Piedel on 30.10.2017.
 */
class MoviesPresenter(val moviesView: MoviesContract.View) : MoviesContract.Presenter {
    var disposable: Disposable? = null

    init {
        moviesView.presenter = this
    }

    override fun start() {
        //loadMovies
    }

}