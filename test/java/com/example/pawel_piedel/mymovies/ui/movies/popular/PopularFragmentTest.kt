package com.example.pawel_piedel.mymovies.ui.movies.popular

import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.shadows.support.v4.SupportFragmentTestUtil.startFragment

/**
 * Created by Pawel_Piedel on 06.11.2017.
 */
@RunWith(RobolectricTestRunner::class)
class PopularFragmentTest {

    val fragment = PopularFragment.newInstance()

    @Test
    fun onResume() {
        startFragment(fragment)
        assertNotNull(fragment)

        assertEquals(1, fragment.subscriptions.size())
    }

    @Test
    fun onPause() {
        fragment.onPause()
        assertEquals(0, fragment.subscriptions.size())
    }

    @Test
    fun bindPopularMovies() {
    }

    @Test
    fun showMovies() {
    }

    @Test
    fun showError() {
    }

    @Test
    fun unbind() {
    }

}