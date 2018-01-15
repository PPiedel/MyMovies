package com.example.pawel_piedel.mymovies.movie_details

import com.example.pawel_piedel.mymovies.data.model.model.Movie
import com.example.pawel_piedel.mymovies.data.source.MoviesRepository
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by Pawel_Piedel on 13.01.2018.
 */
class MovieDetailsViewModel @Inject
constructor(private val moviesRepository: MoviesRepository) {

    fun loadMovieDetails(id: Int): Flowable<Movie> {
        return moviesRepository.getMovieDetails(id)
    }
}