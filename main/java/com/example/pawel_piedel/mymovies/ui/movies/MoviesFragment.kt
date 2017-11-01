package com.example.pawel_piedel.mymovies.ui.movies

import android.app.Fragment
import android.os.Bundle

/**
 * Created by Pawel_Piedel on 30.10.2017.
 */
class MoviesFragment : Fragment() {


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