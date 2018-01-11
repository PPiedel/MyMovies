package com.example.pawel_piedel.mymovies.local

import android.support.test.InstrumentationRegistry
import com.example.pawel_piedel.mymovies.data.model.model.*
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmList
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.hasItem
import org.hamcrest.Matchers.hasSize
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations


/**
 * Created by Pawel_Piedel on 08.01.2018.
 */


/**
 * Created by Pawel_Piedel on 08.01.2018.
 */
class LocalSourceTest {
    lateinit var testRealm: Realm
    lateinit var localSource: LocalSource

    @Before
    fun init() {
        MockitoAnnotations.initMocks(this)

        val context = InstrumentationRegistry.getTargetContext()
        Realm.init(context)
        val testConfig = RealmConfiguration.Builder().inMemory().name("test-realm").build()
        testRealm = Realm.getInstance(testConfig)

        localSource = LocalSource(testRealm)
    }

    @After
    fun close() {
        testRealm.close()
    }

    @Test
    fun getMovies() {
        val testCategory = MoviesCategory.DEFAULT.name
        val testMovies: RealmList<Movie> = createDummyMovies()
        val response = MoviesResponse(1, 3, 1, testMovies, testCategory)
        testRealm.executeTransaction { realm -> realm.copyToRealmOrUpdate(response) }

        val movies: List<Movie> = localSource.getMovies(MoviesCategory.DEFAULT, 1)

        assertThat(movies, hasSize(3))
    }

    private fun createDummyMovies(): RealmList<Movie> {
        val movie1 = Movie(1, RealmList<ProductionCompany>(), RealmList<ProductionCountry>(), RealmList<Genre>(), RealmList<SpokenLanguage>())
        val movie2 = Movie(2, RealmList<ProductionCompany>(), RealmList<ProductionCountry>(), RealmList<Genre>(), RealmList<SpokenLanguage>())
        val movie3 = Movie(3, RealmList<ProductionCompany>(), RealmList<ProductionCountry>(), RealmList<Genre>(), RealmList<SpokenLanguage>())
        val testMovies = RealmList<Movie>(movie1, movie2, movie3)
        return testMovies
    }

}