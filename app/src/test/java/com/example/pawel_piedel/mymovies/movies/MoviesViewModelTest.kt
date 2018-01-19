package com.example.pawel_piedel.mymovies.movies

import android.Manifest
import com.example.pawel_piedel.mymovies.data.model.model.Movie
import com.example.pawel_piedel.mymovies.data.model.model.MoviesCategory
import com.example.pawel_piedel.mymovies.data.source.MoviesRepository
import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.Flowable
import io.reactivex.Observable
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

/**
 * Created by ppiedel on 19.01.18.
 */
class MoviesViewModelTest {

    @Mock
    lateinit var moviesRepository  : MoviesRepository

    @Mock
    lateinit var testMovies : List<Movie>

    @Mock
    lateinit var rxPermissions : RxPermissions

    lateinit var viewModel : MoviesViewModel

    @Before
    fun  init(){
        MockitoAnnotations.initMocks(this)

        viewModel = MoviesViewModel(moviesRepository)
    }

    @Test
    fun loadMoviesShouldReturnEmptyValue() {
        val category = MoviesCategory.DEFAULT
        val testPage = 1
        `when`(moviesRepository.getMovies(category,testPage)).thenReturn(Flowable.just(testMovies))


        viewModel.loadMovies(category,testPage).test().assertNoValues()
    }

    @Test
    fun loadMoviesShouldReturnCorrectResult() {
        val category = MoviesCategory.POPULAR
        val testPage = 1
        `when`(moviesRepository.getMovies(category,testPage)).thenReturn(Flowable.just(testMovies))


        viewModel.loadMovies(category,testPage).test().assertValue(testMovies)
    }

    @Test
    fun loadPopularMovies() {
        val category = MoviesCategory.POPULAR
        val testPage = 1

        `when`(moviesRepository.getMovies(category,testPage)).thenReturn(Flowable.just(testMovies))


        viewModel.loadMovies(category,testPage).test().assertValue(testMovies)
    }

    @Test
    fun loadTopRatedMovies() {
        val category = MoviesCategory.TOP_RATED
        val testPage = 1

        `when`(moviesRepository.getMovies(category,testPage)).thenReturn(Flowable.just(testMovies))


        viewModel.loadMovies(category,testPage).test().assertValue(testMovies)
    }

    @Test
    fun loadUpcomingMovies() {
        val category = MoviesCategory.UPCOMING
        val testPage = 1

        `when`(moviesRepository.getMovies(category,testPage)).thenReturn(Flowable.just(testMovies))


        viewModel.loadMovies(category,testPage).test().assertValue(testMovies)
    }

    @Test
    fun loadNowPlayingMovies() {
        val category = MoviesCategory.NOW_PLAYING
        val testPage = 1

        `when`(moviesRepository.getMovies(category,testPage)).thenReturn(Flowable.just(testMovies))


        viewModel.loadMovies(category,testPage).test().assertValue(testMovies)
    }

    @Test
    fun onPermissionsAvailableShouldReturnTrue() {
        val permission = Manifest.permission.INTERNET
        val permissionGranted = true
        `when`(rxPermissions.request(permission)).thenReturn(Observable.just(permissionGranted))

        viewModel.onPermissionsAvailable(rxPermissions).test().assertValue(permissionGranted)
    }

    @Test
    fun onPermissionsAvailableShouldReturnFalse() {
        val permission = Manifest.permission.INTERNET
        val permissionGranted = false
        `when`(rxPermissions.request(permission)).thenReturn(Observable.just(permissionGranted))

        viewModel.onPermissionsAvailable(rxPermissions).test().assertValue(permissionGranted)
    }

}