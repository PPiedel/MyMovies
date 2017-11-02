package com.example.pawel_piedel.mymovies.data.source.remote

import com.example.pawel_piedel.mymovies.BuildConfig
import com.example.pawel_piedel.mymovies.data.model.Movie
import com.example.pawel_piedel.mymovies.data.model.MoviesResponse
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Pawel_Piedel on 30.10.2017.
 */

interface ApiService {
    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path(MOVIE_ID_PARAM) id: String,
                        @Query(API_KEY_PARAM) apiKey: String = API_KEY): Flowable<Movie>

    @GET("movie/{movie_id}/similar")
    fun getSimilarMovies(@Path(MOVIE_ID_PARAM) id: String,
                         @Query(API_KEY_PARAM) apiKey: String = API_KEY): Flowable<MoviesResponse>

    @GET("movie/{movie_id}/recommendations")
    fun getRecomendedMovies(@Path(MOVIE_ID_PARAM) id: String,
                            @Query(API_KEY_PARAM) apiKey: String = API_KEY): Flowable<MoviesResponse>

    @GET("movie/top_rated")
    fun getTopRatedMovies(@Query(API_KEY_PARAM) apiKey: String = API_KEY): Flowable<MoviesResponse>

    @GET("movie/upcoming")
    fun getUpcomingMovies(@Query(API_KEY_PARAM) apiKey: String = API_KEY): Flowable<MoviesResponse>

    @GET("movie/popular")
    fun getPopularMovies(@Query(API_KEY_PARAM) apiKey: String = API_KEY): Flowable<MoviesResponse>

    @GET("movie/now_playing")
    fun getNowPlayingMovies(@Query(API_KEY_PARAM) apiKey: String = API_KEY): Flowable<MoviesResponse>

    companion object {
        const val API_KEY = BuildConfig.API_KEY
        const val API_KEY_PARAM = "api_key"
        const val MOVIE_ID_PARAM = "movie_id"
        const val BASE_URL = "https://api.themoviedb.org/3/"
    }


}