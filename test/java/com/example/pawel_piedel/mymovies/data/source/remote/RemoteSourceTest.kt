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

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        remoteSource = RemoteSource(apiService)
    }

    @Test
    fun getTopRatedMovies() {
        remoteSource.getTopRatedMovies()

        verify(apiService).getTopRatedMovies()
    }

    @Test
    fun getUpcomingMovies() {
        remoteSource.getUpcomingMovies()

        verify(apiService).getUpcomingMovies()
    }

    @Test
    fun getPopularMovies() {
        remoteSource.getPopularMovies()

        verify(apiService).getPopularMovies()
    }

    @Test
    fun getMovieDetails() {
        val testTitle = "test"
        remoteSource.getMovieDetails(testTitle)

        verify(apiService).getMovieDetails(testTitle)
    }

}