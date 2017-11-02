package com.example.pawel_piedel.mymovies.ui.movies

import com.example.pawel_piedel.mymovies.data.model.Movie
import com.example.pawel_piedel.mymovies.data.model.MoviesCategory
import com.example.pawel_piedel.mymovies.ui.base.BaseView


interface MoviesContract {
    interface View : BaseView {
        fun showMovies(movies: List<Movie>)
    }

    interface Presenter : com.example.pawel_piedel.mymovies.ui.base.Presenter<View> {
        fun loadMovies(moviesCategory: MoviesCategory)
    }
}