package com.example.pawel_piedel.mymovies.data.source.remote

import com.example.pawel_piedel.myapplication.BuildConfig
import com.example.pawel_piedel.mymovies.data.model.model.Movie
import com.example.pawel_piedel.mymovies.data.model.model.MoviesResponse
import io.reactivex.Flowable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Pawel_Piedel on 30.10.2017.
 */

interface ApiService {
    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path(MOVIE_ID) id: String,
                        @Query(API_KEY_PARAM) apiKey: String = API_KEY): Single<Movie>

    @GET("movie/{movie_id}/similar")
    fun getSimilarMovies(@Path(MOVIE_ID) id: String,
                         @Query(API_KEY_PARAM) apiKey: String = API_KEY): Flowable<MoviesResponse>

    @GET("movie/{movie_id}/recommendations")
    fun getRecomendedMovies(@Query(API_KEY_PARAM) apiKey: String = API_KEY): Flowable<MoviesResponse>

    @GET("movie/top_rated")
    fun getTopRatedMovies(@Query(LANGUAGE) lang: String = "en",
                          @Query(API_KEY_PARAM) apiKey: String = API_KEY): Flowable<MoviesResponse>

    @GET("movie/upcoming")
    fun getUpcomingMovies(@Query(LANGUAGE) lang: String = "en",
                          @Query(API_KEY_PARAM) apiKey: String = API_KEY): Flowable<MoviesResponse>

    @GET("movie/popular")
    fun getPopularMovies(@Query(LANGUAGE) lang: String = "en",
                         @Query(API_KEY_PARAM) apiKey: String = API_KEY): Flowable<MoviesResponse>

    @GET("movie/now_playing")
    fun getNowPlayingMovies(@Query(API_KEY_PARAM) apiKey: String = API_KEY): Flowable<MoviesResponse>

    companion object {
        const val BASE_URL = "https://api.themoviedb.org/3/"
        const val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w500"
        const val API_KEY = BuildConfig.API_KEY
        const val API_KEY_PARAM = "api_key"
        const val LANGUAGE = "language"
        const val MOVIE_ID = "movie_id"
        const val PAGE = "page"

    }


}