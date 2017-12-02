package com.example.pawel_piedel.mymovies.data.source

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
        val cache: List<Movie> = (localDataSource::getMovies)(moviesCategory, page)

        Timber.d("Cached movies : ", cache.iterator().forEach { movie -> movie.toString() })

        return if (cache.isEmpty()) {
            remoteDataSource.getMovies(moviesCategory)
                    .subscribeOn(Schedulers.io())
                    .observeOn(Schedulers.computation())
                    .doOnNext { t: MoviesResponse -> t.category = moviesCategory.name; t.id = t.hashCode() }
                    .observeOn(AndroidSchedulers.mainThread())
                    .map { response -> (localDataSource::saveMoviesResponse)(response) }
                    .map { (localDataSource::getMovies)(moviesCategory, page) }
        } else {
            Timber.d("Zwracam tylko cache")
            Flowable.just(cache).subscribeOn(Schedulers.io())
        }


    }


    override fun getMovieDetails(id: String): Flowable<Movie> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}