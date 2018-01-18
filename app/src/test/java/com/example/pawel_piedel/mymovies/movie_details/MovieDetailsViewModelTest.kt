package com.example.pawel_piedel.mymovies.movie_details

import com.example.pawel_piedel.mymovies.data.model.model.Movie
import com.example.pawel_piedel.mymovies.data.source.MoviesRepository
import io.reactivex.Flowable
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import java.net.SocketTimeoutException

/**
 * Created by Pawel_Piedel on 13.01.2018.
 */
class MovieDetailsViewModelTest {
    @Mock
    lateinit var moviesRepository : MoviesRepository

    @Mock
    lateinit var movie : Movie

    lateinit var movieDetailsViewModel : MovieDetailsViewModel

    @Before
    fun init(){
        MockitoAnnotations.initMocks(this)

        movieDetailsViewModel = MovieDetailsViewModel(moviesRepository)
    }


    @Test
    fun loadMovieDetailsShouldReturnCorrectResponse() {
        val testId = 1
        `when`(moviesRepository.getMovieDetails(testId)).thenReturn(Flowable.just(movie))

        movieDetailsViewModel.loadMovieDetails(testId).test().assertValue(movie)

    }

    @Test
    fun loadMovieDetailsShouldReturnEmptyResponse(){
        val testId : Int = 1
        `when`(moviesRepository.getMovieDetails(testId)).thenReturn(Flowable.empty())

        movieDetailsViewModel.loadMovieDetails(testId).test().assertNoValues()
    }

    @Test
    fun loadMovieDetailsShouldReturnSocketTimeoutException(){
        val testId : Int = 1
        val error = SocketTimeoutException()
        `when`(moviesRepository.getMovieDetails(testId)).thenReturn(Flowable.error(error))

        movieDetailsViewModel.loadMovieDetails(testId).test().assertError(error)
    }

}