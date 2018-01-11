package com.example.pawel_piedel.mymovies.data.source

import com.example.pawel_piedel.mymovies.data.model.model.Movie
import com.example.pawel_piedel.mymovies.data.model.model.MoviesCategory
import com.example.pawel_piedel.mymovies.data.model.model.MoviesResponse
import com.example.pawel_piedel.mymovies.local.LocalDataSource
import com.example.pawel_piedel.mymovies.data.source.remote.RemoteDataSource
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by Pawel_Piedel on 30.10.2017.
 */
class MoviesRepository @Inject
constructor(private val remoteDataSource: RemoteDataSource, private val localDataSource: LocalDataSource) : MoviesDataSource {


    override fun getMovies(moviesCategory: MoviesCategory, page: Int): Flowable<List<Movie>> {
        Timber.d("Page : " + page)
        val cache: List<Movie> = localDataSource.getMovies(moviesCategory, page)

        return if (cache.isEmpty()) {
            remoteDataSource.getMovies(moviesCategory, page)
                    //  .filter { t: MoviesResponse -> t.results.isEmpty() }
                    .observeOn(Schedulers.computation())
                    .doOnNext { t: MoviesResponse -> t.category = moviesCategory.name; t.id = t.hashCode() }
                    .doOnNext { t -> (localDataSource::saveMoviesResponse)(t) }
                    .map { t -> t.results.toList() }
                   // .doOnNext { t: List<Movie>? -> t?.iterator()?.forEach { movie -> Log.d("API Movie", movie.toString()) } }
        } else {
            //cache.iterator().forEach { movie -> Log.d("Cached movie", movie.toString()) }
            Flowable.just(cache)
        }
    }


    override fun getMovieDetails(id: String): Flowable<Movie> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}