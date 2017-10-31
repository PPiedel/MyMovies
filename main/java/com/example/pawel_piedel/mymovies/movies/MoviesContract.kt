package com.example.pawel_piedel.mymovies.movies

import com.example.pawel_piedel.mymovies.base.BaseView
import com.example.pawel_piedel.mymovies.data.model.Movie
import com.example.pawel_piedel.mymovies.data.model.MoviesCategory


interface MoviesContract {
    interface View : BaseView {
        fun show(movies: List<Movie>)
    }

    interface Presenter : com.example.pawel_piedel.mymovies.base.Presenter<View> {
        fun loadMovies(moviesCategory: MoviesCategory)
    }
}