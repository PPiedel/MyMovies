package com.example.pawel_piedel.mymovies.movies

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.swipeRight
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import com.example.pawel_piedel.myapplication.R
import org.junit.Rule
import org.junit.Test


/**
 *
 * Created by Pawel_Piedel on 11.01.2018.
 */
class MoviesActivityTest {
    @Rule @JvmField
    val mActivityRule = ActivityTestRule(MoviesActivity::class.java)

    @Test
    fun checkToolbarIsDisplayed() {
        checkNotNull(withId(R.id.toolbar))
        onView(withId(R.id.toolbar)).check(matches(isDisplayed()));
    }

    @Test
    fun checkToolbarTitle(){
        onView(withText(R.string.app_name)).check(matches(withParent(withId(R.id.toolbar))));
    }

    @Test
    fun swipeRightTest(){
        onView(withId(R.id.viewpager)).perform(swipeRight()).check(matches(isDisplayed()));
    }

    @Test
    fun swipeRightDoubleTest(){
        onView(withId(R.id.viewpager)).perform(swipeRight()).perform(swipeRight()).check(matches(isDisplayed()));
    }

}