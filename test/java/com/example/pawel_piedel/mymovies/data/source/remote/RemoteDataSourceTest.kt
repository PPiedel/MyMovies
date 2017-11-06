package com.example.pawel_piedel.mymovies.data.source.remote

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

/**
 * Created by Pawel_Piedel on 06.11.2017.
 */
class RemoteDataSourceTest {

    @Mock
    lateinit var apiService: ApiService

    lateinit var remoteDataSource: RemoteDataSource

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        remoteDataSource = RemoteDataSource(apiService)
    }

    @Test
    fun getTopRatedMovies() {
        remoteDataSource.getTopRatedMovies()

        verify(apiService).getTopRatedMovies()
    }

    @Test
    fun getUpcomingMovies() {
        remoteDataSource.getUpcomingMovies()

        verify(apiService).getUpcomingMovies()
    }

    @Test
    fun getPopularMovies() {
        remoteDataSource.getPopularMovies()

        verify(apiService).getPopularMovies()
    }

    @Test
    fun getMovieDetails() {
        val testTitle = "test"
        remoteDataSource.getMovieDetails(testTitle)

        verify(apiService).getMovieDetails(testTitle)
    }

}