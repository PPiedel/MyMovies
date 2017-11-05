package com.example.pawel_piedel.mymovies.ui.movies.upcoming

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pawel_piedel.mymovies.R
import com.example.pawel_piedel.mymovies.data.model.Movie
import javax.inject.Inject

/**
 * Created by Pawel_Piedel on 04.11.2017.
 */
class UpcomingFragment : Fragment()  {



    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater?.inflate(R.layout.fragment_movies, container, false)
    }

    companion object {
        fun newInstance(): UpcomingFragment {
            return UpcomingFragment()
        }
    }
}