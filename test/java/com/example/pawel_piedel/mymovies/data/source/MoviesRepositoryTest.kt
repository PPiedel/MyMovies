package com.example.pawel_piedel.mymovies.data.source

import com.example.pawel_piedel.mymovies.data.model.model.Movie
import com.example.pawel_piedel.mymovies.data.model.model.MoviesCategory
import com.example.pawel_piedel.mymovies.data.model.model.MoviesResponse
import com.example.pawel_piedel.mymovies.local.LocalDataSource
import com.example.pawel_piedel.mymovies.data.source.remote.RemoteDataSource
import io.reactivex.Flowable
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.BlockJUnit4ClassRunner
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

/**
 * Created by Pawel_Piedel on 05.11.2017.
 */
@RunWith(BlockJUnit4ClassRunner::class)
internal class MoviesRepositoryTest {

    @Mock
    lateinit var movieResponse: MoviesResponse

    lateinit var testMovies: List<Movie>

    @Mock
    lateinit var emptyMovies: List<Movie>

    @Mock
    lateinit var remoteDataSource: RemoteDataSource


    @Mock
    lateinit var localDataSource: LocalDataSource

    @Mock
    lateinit var movie: Movie

    lateinit var moviesRepository: MoviesRepository


    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        moviesRepository = MoviesRepository(remoteDataSource, localDataSource)

        testMovies = listOf(movie, movie, movie)

    }

    @Test
    fun repositoryShouldReturnCachedMovies() {
        val category = MoviesCategory.POPULAR
        val testPage = 1
        `when`(localDataSource.getMovies(category, testPage)).thenReturn(testMovies)

        moviesRepository.getMovies(category, testPage).test().assertValue(testMovies)
    }

    @Test
    fun repositoryShouldReturnEmptyList() {
        val category = MoviesCategory.POPULAR
        val testPage = 1
        `when`(localDataSource.getMovies(category, testPage)).thenReturn(emptyList())
        `when`(remoteDataSource.getMovies(category, testPage)).thenReturn(Flowable.empty())

        moviesRepository.getMovies(category, testPage).test().assertEmpty()
    }

}