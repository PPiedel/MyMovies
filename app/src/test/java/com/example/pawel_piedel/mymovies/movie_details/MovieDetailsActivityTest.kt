package com.example.pawel_piedel.mymovies.movie_details

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import android.app.Activity
import com.example.pawel_piedel.myapplication.BuildConfig
import junit.framework.Assert.assertNotNull
import org.robolectric.android.controller.ActivityController
import org.robolectric.annotation.Config


/**
 * Created by Pawel_Piedel on 14.01.2018.
 */
@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class,packageName = "com.example.pawel_piedel.mymovies.movie_details ")
class MovieDetailsActivityTest {

   @Test
    fun onCreateTest(){
       val controller = Robolectric.buildActivity(MovieDetailsActivity::class.java)
       val activity = controller.create().get()

       assertNotNull(activity.supportActionBar)
   }

}