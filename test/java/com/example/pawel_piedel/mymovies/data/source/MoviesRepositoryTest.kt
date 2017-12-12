package com.example.pawel_piedel.mymovies.data.source

import com.example.pawel_piedel.mymovies.data.model.model.Movie
import com.example.pawel_piedel.mymovies.data.model.model.MoviesCategory
import com.example.pawel_piedel.mymovies.data.model.model.MoviesResponse
import com.example.pawel_piedel.mymovies.data.source.local.LocalDataSource
import com.example.pawel_piedel.mymovies.data.source.remote.RemoteDataSource
import io.reactivex.Flowable
import io.realm.RealmList
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.any
import org.mockito.MockitoAnnotations

/**
 * Created by Pawel_Piedel on 05.11.2017.
 */
internal class MoviesRepositoryTest {

    @Mock
    lateinit var movieResponse: MoviesResponse

    lateinit var testMovies: List<Movie>

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
    fun getCachedMovies() {
        val category = MoviesCategory.POPULAR
        val testPage = 1
        `when`(localDataSource.getMovies(category, testPage)).thenReturn(testMovies)

        moviesRepository.getMovies(category, testPage).test().assertValue(testMovies)
    }

    @Test
    fun getMoviesFromApi() {
        val category = MoviesCategory.POPULAR
        val testPage = 1
        movieResponse.results = RealmList(movie, movie, movie)
        `when`(localDataSource.getMovies(category, testPage)).thenReturn(emptyList())
        `when`(remoteDataSource.getMovies(category, testPage)).thenReturn(Flowable.just(movieResponse))
        `when`((localDataSource::saveMoviesResponse)(ArgumentMatchers.any(MoviesResponse::class.java))).thenReturn(Unit)

        moviesRepository.getMovies(category, testPage).test().assertResult(movieResponse.results)
    }

}