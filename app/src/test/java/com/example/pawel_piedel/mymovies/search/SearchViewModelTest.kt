package com.example.pawel_piedel.mymovies.search

import com.example.pawel_piedel.mymovies.data.model.model.Movie
import com.example.pawel_piedel.mymovies.data.source.MoviesRepository
import io.reactivex.Flowable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import java.util.*

/**
 * Created by PPiedel on 29.03.2018.
 */
class SearchViewModelTest {
    @Mock
    lateinit var moviesRepository: MoviesRepository

    @Mock
    lateinit var testMovie : Movie

    lateinit var searchViewModel : SearchViewModel

    @Before
    public fun init() {
        MockitoAnnotations.initMocks(this)
        searchViewModel = SearchViewModel(moviesRepository);
    }

    @Test
    fun loadSearchResultsShouldReturnListOfOneMovie() {
        val query = "testQuery";
        `when`(moviesRepository.loadSearchResults(query)).thenReturn(Flowable.just(Collections.singletonList(testMovie)))

        searchViewModel.loadSearchResults(query).test().assertValue(Collections.singletonList(testMovie))
    }

    @Test
    fun loadSearchResultsShouldReturnEmpty(){
        val query = "testQuery";
        `when`(moviesRepository.loadSearchResults(query)).thenReturn(Flowable.empty())

        searchViewModel.loadSearchResults(query).test().assertNoValues()
    }

}