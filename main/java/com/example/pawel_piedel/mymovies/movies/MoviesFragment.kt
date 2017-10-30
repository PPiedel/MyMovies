package com.example.pawel_piedel.mymovies.movies

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pawel_piedel.mymovies.R
import kotlinx.android.synthetic.main.fragment_main.view.*

/**
 * Created by Pawel_Piedel on 30.10.2017.
 */
class MoviesFragment : Fragment(), MoviesContract.View {

    override lateinit var presenter: MoviesContract.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_main, container, false)
        return rootView
    }

    override fun onResume() {
        super.onResume()
        presenter.start()
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