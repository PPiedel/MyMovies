package com.example.pawel_piedel.mymovies.data.source

import com.example.pawel_piedel.mymovies.data.model.model.Movie
import com.example.pawel_piedel.mymovies.data.model.model.MoviesResponse
import io.reactivex.Flowable
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.anyString
import org.mockito.MockitoAnnotations

/**
 * Created by Pawel_Piedel on 05.11.2017.
 */
internal class MoviesRepositoryTest {

    @Mock
    lateinit var movieResponse: MoviesResponse

    @Mock
    lateinit var remoteDataSource: MoviesDataSource

    @Mock
    lateinit var localDataSource: MoviesDataSource

    @Mock
    lateinit var movie: Movie

    lateinit var moviesRepository: MoviesRepository

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        moviesRepository = MoviesRepository(remoteDataSource, localDataSource)

    }


    @Test
    fun getTopRatedMovies() {
        `when`(remoteDataSource.getTopRatedMovies()).thenReturn(Flowable.just(movieResponse))

        moviesRepository.getTopRatedMovies().test().assertValue(movieResponse)

    }

    @Test
    fun getUpcomingMovies() {
        `when`(remoteDataSource.getUpcomingMovies()).thenReturn(Flowable.just(movieResponse))

        moviesRepository.getUpcomingMovies().test().assertValue(movieResponse)
    }

    @Test
    fun getPopularMovies() {
        `when`(remoteDataSource.getPopularMovies()).thenReturn(Flowable.just(movieResponse))

        moviesRepository.getPopularMovies().test().assertValue(movieResponse)
    }

    @Test
    fun getMovieDetails() {
        `when`(remoteDataSource.getMovieDetails(ArgumentMatchers.anyString())).thenReturn(Flowable.just(movie))

        moviesRepository.getMovieDetails("test").test().assertValue(movie)
    }

}