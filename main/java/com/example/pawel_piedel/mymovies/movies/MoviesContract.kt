package com.example.pawel_piedel.mymovies.movies

import com.example.pawel_piedel.mymovies.BasePresenter
import com.example.pawel_piedel.mymovies.BaseView


interface MoviesContract {
    interface View : BaseView<Presenter> {

    }

    interface Presenter : BasePresenter {

    }
}