package com.example.pawel_piedel.mymovies.search

import com.example.pawel_piedel.mymovies.data.model.model.Movie
import com.example.pawel_piedel.mymovies.data.source.MoviesRepository
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by PPiedel on 20.01.2018.
 */
class SearchViewModel @Inject
constructor(private val moviesRepository: MoviesRepository) {

    fun loadSearchResults(query: String): Flowable<List<Movie>> {
        return moviesRepository.loadSearchResults(query)
    }

}