package com.example.pawel_piedel.mymovies.data.source.local

import com.example.pawel_piedel.mymovies.data.model.model.Movie
import com.example.pawel_piedel.mymovies.data.model.model.MoviesCategory
import com.example.pawel_piedel.mymovies.data.model.model.MoviesResponse
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Single
import io.requery.Persistable
import io.requery.kotlin.eq
import io.requery.query.Condition
import io.requery.reactivex.KotlinReactiveEntityStore
import javax.inject.Inject

/**
 * Created by Pawel_Piedel on 25.11.2017.
 */

class LocalSource @Inject
constructor(val data: KotlinReactiveEntityStore<Persistable>) : LocalDataSource {

    override fun saveMovies(movies: List<Movie>): Completable {
        return data.insert(movies).toCompletable()
    }

    override fun findMovieById(id: String): Maybe<Movie> {
        return data.findByKey(Movie::class, id)
    }

    override fun getTopRatedMovies(): Flowable<Movie> {
        return data.select(Movie::class).where(Movie::category.eq(MoviesCategory.TOP_RATED.name)).get().flowable()
    }

    override fun getUpcomingMovies(): Flowable<Movie> {
        return data.select(Movie::class).where(Movie::category.eq(MoviesCategory.UPCOMING.name)).get().flowable()
    }

    override fun getPopularMovies(): Flowable<Movie> {
        return data.select(Movie::class).where(Movie::category.eq(MoviesCategory.POPULAR.name)).get().flowable()
    }

}
