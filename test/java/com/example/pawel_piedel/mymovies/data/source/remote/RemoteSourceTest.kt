package com.example.pawel_piedel.mymovies.data.source.remote

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

/**
 * Created by Pawel_Piedel on 06.11.2017.
 */
class RemoteSourceTest {

    @Mock
    lateinit var apiService: ApiService

    lateinit var remoteSource: RemoteSource

    val pageNumber = 0

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        remoteSource = RemoteSource(apiService)
    }

    @Test
    fun getTopRatedMovies() {
        remoteSource.getTopRatedMovies(pageNumber)

        verify(apiService).getTopRatedMovies(pageNumber)
    }

    @Test
    fun getUpcomingMovies() {
        remoteSource.getUpcomingMovies(pageNumber)

        verify(apiService).getUpcomingMovies(pageNumber)
    }

    @Test
    fun getPopularMovies() {
        remoteSource.getPopularMovies(pageNumber)

        verify(apiService).getPopularMovies(pageNumber)
    }

    @Test
    fun getMovieDetails() {
        val testId = 1
        remoteSource.getMovieDetails(testId)

        verify(apiService).getMovieDetails(testId)
    }

}