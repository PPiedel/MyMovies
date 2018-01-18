package com.example.pawel_piedel.mymovies.data.source.remote

import com.example.pawel_piedel.mymovies.data.model.model.Movie
import com.example.pawel_piedel.mymovies.data.model.model.MoviesResponse
import io.reactivex.Flowable
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

/**
 * Created by Pawel_Piedel on 06.11.2017.
 */
class RemoteSourceTest {

    @Mock
    lateinit var apiService: ApiService

    @Mock
    lateinit var movieResponse: MoviesResponse

    @Mock
    lateinit var movie: Movie

    lateinit var remoteSource: RemoteSource

    val testPage = 0

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        remoteSource = RemoteSource(apiService)
    }

    @Test
    fun getTopRatedMovies() {
        remoteSource.getTopRatedMovies(testPage)

        verify(apiService).getTopRatedMovies(testPage)
    }

    @Test
    fun getTopRatedMoviesShouldReturnResult() {
        `when`(apiService.getTopRatedMovies(testPage)).thenReturn(Flowable.just(movieResponse))

        remoteSource.getTopRatedMovies(testPage).test().assertValue(movieResponse)
    }

    @Test
    fun getTopRatedMoviesShouldReturnEmpty() {
        `when`(apiService.getTopRatedMovies(testPage)).thenReturn(Flowable.empty())

        remoteSource.getTopRatedMovies(testPage).test().assertComplete().assertNoValues()
    }

    @Test
    fun getUpcomingMovies() {
        remoteSource.getUpcomingMovies(testPage)

        verify(apiService).getUpcomingMovies(testPage)
    }

    @Test
    fun getUpcomingMoviesShouldReturnResult() {
        `when`(remoteSource.getUpcomingMovies(testPage)).thenReturn(Flowable.just(movieResponse))

        remoteSource.getUpcomingMovies(testPage).test().assertValue(movieResponse)
    }

    @Test
    fun getUpcomingMoviesShouldReturnEmptyResult() {
        `when`(remoteSource.getUpcomingMovies(testPage)).thenReturn(Flowable.empty())

        remoteSource.getUpcomingMovies(testPage).test().assertComplete().assertNoValues()
    }

    @Test
    fun getPopularMovies() {
        remoteSource.getPopularMovies(testPage)

        verify(apiService).getPopularMovies(testPage)
    }

    @Test
    fun getPopularMoviesShouldReturnCorrectResult() {
        `when`(remoteSource.getPopularMovies(testPage)).thenReturn(Flowable.just(movieResponse))

        remoteSource.getPopularMovies(testPage).test().assertValue(movieResponse)
    }

    @Test
    fun getPopularMoviesShouldReturnEmptyResult() {
        `when`(remoteSource.getPopularMovies(testPage)).thenReturn(Flowable.empty())

        remoteSource.getPopularMovies(testPage).test().assertComplete().assertNoValues()
    }

    @Test
    fun getMovieDetails() {
        val testId = 1
        remoteSource.getMovieDetails(testId)

        verify(apiService).getMovieDetails(testId)
    }

    @Test
    fun getMovieDetailsShouldReturnCorrectResponse() {
        val testId = 1
        `when`(remoteSource.getMovieDetails(testId)).thenReturn(Flowable.just(movie))

        remoteSource.getMovieDetails(testId).test().assertValue(movie).assertComplete()
    }

    @Test
    fun getMovieDetailsShouldReturnEmptyResponse() {
        val testId = 1
        val error = Throwable("Test error")
        `when`(remoteSource.getMovieDetails(testId)).thenReturn(Flowable.error(error))

        remoteSource.getMovieDetails(testId).test().assertError(error)
    }

}