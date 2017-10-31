package com.example.pawel_piedel.mymovies.movies

import android.os.Bundle
import com.example.pawel_piedel.mymovies.R
import com.example.pawel_piedel.mymovies.base.BaseFragment
import com.example.pawel_piedel.mymovies.movies.MoviesFragment.PlaceholderFragment.Companion.ARG_SECTION_NUMBER

/**
 * Created by Pawel_Piedel on 30.10.2017.
 */
class MoviesFragment : BaseFragment() {
    override fun layoutId() = R.layout.fragment_main

    fun getFragmentNumber(): Int {
        return arguments.getInt(ARG_SECTION_NUMBER)
    }

    class PlaceholderFragment : android.support.v4.app.Fragment() {
        companion object {
            val ARG_SECTION_NUMBER = "section_number"

            fun newInstance(sectionNumber: Int): PlaceholderFragment {
                val fragment = PlaceholderFragment()
                val args = Bundle()
                args.putInt(ARG_SECTION_NUMBER, sectionNumber)
                fragment.arguments = args
                return fragment
            }
        }
    }
}