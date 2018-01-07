package com.example.pawel_piedel.mymovies.data.source

import android.util.Log
import com.example.pawel_piedel.mymovies.data.model.model.Movie
import com.example.pawel_piedel.mymovies.data.model.model.MoviesCategory
import com.example.pawel_piedel.mymovies.data.model.model.MoviesResponse
import com.example.pawel_piedel.mymovies.data.source.local.LocalDataSource
import com.example.pawel_piedel.mymovies.data.source.remote.RemoteDataSource
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
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

        Timber.d("Cached movies : ", cache.iterator().forEach { movie -> movie.toString() })
        Timber.d("Cache size : " + cache.size)
        Timber.d("Cache is empty :" + cache.isEmpty())
        return if (cache.isEmpty()) {
            Timber.d("Wysylam GET dla page : " + page)
            remoteDataSource.getMovies(moviesCategory, page)
                    .observeOn(AndroidSchedulers.mainThread())
                    //.observeOn(Schedulers.computation())
                    .doOnNext { t: MoviesResponse -> t.category = moviesCategory.name; t.id = t.hashCode() }
                    .map { response -> (localDataSource::saveMoviesResponse)(response) }
                    .map { (localDataSource::getMovies)(moviesCategory, page) }
                    .doOnNext { t: List<Movie>? ->
                        t?.iterator()?.forEach { movie ->
                            Log.d("Repository", movie.toString())
                        }
                    }
        } else {
            Timber.d("Cached movies : ", cache.toString())
            Timber.d("Cached movies : ", cache.iterator().forEach { movie -> movie.toString() })
            Flowable.just(cache)
        }


    }


    override fun getMovieDetails(id: String): Flowable<Movie> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}