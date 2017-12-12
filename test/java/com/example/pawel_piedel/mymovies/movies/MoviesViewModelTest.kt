package com.example.pawel_piedel.mymovies.movies

import com.example.pawel_piedel.mymovies.data.model.model.Movie
import com.example.pawel_piedel.mymovies.data.model.model.MoviesCategory
import com.example.pawel_piedel.mymovies.data.source.MoviesRepository
import io.reactivex.Flowable
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

/**
 * Created by Pawel_Piedel on 11.12.2017.
 */
class MoviesViewModelTest {

    @Mock
    lateinit var moviesRepository: MoviesRepository

    @Mock
    lateinit var movie: Movie

    @Mock
    lateinit var movies: List<Movie>

    lateinit var viewModel: MoviesViewModel

    val testPage = 1

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        viewModel = MoviesViewModel(moviesRepository)

        assertNotNull(viewModel.loadingIndicator)

    }

    @Test
    fun firstLoadMorePopularMovies() {
        `when`(moviesRepository.getMovies(MoviesCategory.POPULAR, 2)).thenReturn(Flowable.just(movies))
        viewModel.loadMoreMovies(MoviesCategory.POPULAR)

        assertEquals(2, viewModel.popularPage)
    }

    @Test
    fun loadMorePopularMovies() {
        viewModel.popularPage = 9
        `when`(moviesRepository.getMovies(MoviesCategory.POPULAR, 10)).thenReturn(Flowable.just(movies))

        viewModel.loadMoreMovies(MoviesCategory.POPULAR)

        assertEquals(10, viewModel.popularPage)
    }

    @Test
    fun firstLoadMoreOfTopRatedMovies() {
        `when`(moviesRepository.getMovies(MoviesCategory.TOP_RATED, 2)).thenReturn(Flowable.just(movies))

        viewModel.loadMoreMovies(MoviesCategory.TOP_RATED)

        assertEquals(2, viewModel.topRatedPage)
    }

    @Test
    fun loadMoreTopRatedMovies() {
        viewModel.topRatedPage = 9
        `when`(moviesRepository.getMovies(MoviesCategory.TOP_RATED, 10)).thenReturn(Flowable.just(movies))

        viewModel.loadMoreMovies(MoviesCategory.TOP_RATED)

        assertEquals(10, viewModel.topRatedPage)
    }

    @Test
    fun firstLoadMoreOfUpcomingMovies() {
        `when`(moviesRepository.getMovies(MoviesCategory.UPCOMING, 2)).thenReturn(Flowable.just(movies))
        viewModel.loadMoreMovies(MoviesCategory.UPCOMING)

        assertEquals(2, viewModel.upcomingPage)
    }

    @Test
    fun loadMoreUpcomingMovies() {
        viewModel.upcomingPage = 9
        `when`(moviesRepository.getMovies(MoviesCategory.UPCOMING, 10)).thenReturn(Flowable.just(movies))

        viewModel.loadMoreMovies(MoviesCategory.UPCOMING)

        assertEquals(10, viewModel.upcomingPage)
    }

    @Test
    fun loadPopularMovies() {
        `when`(moviesRepository.getMovies(MoviesCategory.POPULAR, testPage)).thenReturn(Flowable.just(movies))
        viewModel.loadPopularMovies(testPage).test().assertResult(movies)
    }

    @Test
    fun loadTopRatedMovies() {
        `when`(moviesRepository.getMovies(MoviesCategory.TOP_RATED, testPage)).thenReturn(Flowable.just(movies))
        viewModel.loadTopRatedMovies(testPage).test().assertResult(movies)
    }

    @Test
    fun loadUpcomingMovies() {
        `when`(moviesRepository.getMovies(MoviesCategory.UPCOMING, testPage)).thenReturn(Flowable.just(movies))
        viewModel.loadUpcomingMovies(testPage).test().assertResult(movies)

    }

}