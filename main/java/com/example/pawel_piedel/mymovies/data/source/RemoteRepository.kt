package com.example.pawel_piedel.mymovies.data.source

import com.example.pawel_piedel.mymovies.data.model.model.Movie
import com.example.pawel_piedel.mymovies.data.model.model.MoviesCategory
import com.example.pawel_piedel.mymovies.data.source.local.LocalDataSource
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * Created by Pawel_Piedel on 30.10.2017.
 */
class RemoteRepository(private val remoteDataSource: RemoteDataSource, private val localDataSource: LocalDataSource) : MoviesDataSource {

    override fun getMovies(moviesCategory: MoviesCategory): Flowable<List<Movie>> {
        return remoteDataSource.getMovies(moviesCategory)
    }


    override fun getMovieDetails(id: String): Single<Movie> {
        return remoteDataSource.getMovieDetails(id)
    }

}