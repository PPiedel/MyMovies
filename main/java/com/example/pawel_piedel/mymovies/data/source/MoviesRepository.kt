package com.example.pawel_piedel.mymovies.data.source

import com.example.pawel_piedel.mymovies.data.model.model.Movie
import com.example.pawel_piedel.mymovies.data.model.model.MoviesCategory
import com.example.pawel_piedel.mymovies.data.model.model.MoviesResponse
import com.example.pawel_piedel.mymovies.data.source.local.LocalDataSource
import com.example.pawel_piedel.mymovies.data.source.remote.RemoteDataSource
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by Pawel_Piedel on 30.10.2017.
 */
class MoviesRepository @Inject
constructor(private val remoteDataSource: RemoteDataSource, private val localDataSource: LocalDataSource) : MoviesDataSource {


    override fun getMovies(moviesCategory: MoviesCategory): Flowable<List<Movie>> {
        val observable = remoteDataSource.getMovies(moviesCategory)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .doOnNext { t: List<Movie> -> t.iterator().forEach { movie: Movie -> movie.category = moviesCategory.name } }
                .observeOn(AndroidSchedulers.mainThread())
                .map { (localDataSource::saveMovies)(it) }
                .map { (localDataSource::getMovies)(moviesCategory) }
                .doOnNext { t: List<Movie>? -> Timber.d(t.toString()) }


        val cache = localDataSource.getMovies(moviesCategory)
        Timber.d("Cached movies : " + cache.toString())

        return observable.mergeWith(Flowable.just(cache))
    }


    override fun getMovieDetails(id: String): Flowable<Movie> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}