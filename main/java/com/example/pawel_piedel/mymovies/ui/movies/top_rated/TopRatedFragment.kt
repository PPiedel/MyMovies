package com.example.pawel_piedel.mymovies.ui.movies.top_rated

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pawel_piedel.mymovies.R

/**
 * Created by Pawel_Piedel on 04.11.2017.
 */
class TopRatedFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_movies, container, false)
    }

    companion object {
        fun newInstance(): TopRatedFragment {
            return TopRatedFragment()
        }
    }
}
