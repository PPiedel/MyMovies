package com.example.pawel_piedel.mymovies.ui.movies

import com.example.pawel_piedel.mymovies.data.model.Movie
import com.example.pawel_piedel.mymovies.data.model.MoviesCategory


interface MoviesContract {
    interface View {
        fun show(movies: List<Movie>)
    }

    interface Presenter {
        fun loadMovies(moviesCategory: MoviesCategory)
    }
}