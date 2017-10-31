package com.example.pawel_piedel.mymovies.movies

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.pawel_piedel.mymovies.R
import com.example.pawel_piedel.mymovies.base.BaseActivity
import com.example.pawel_piedel.mymovies.data.model.Movie
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MoviesActivity : BaseActivity(), MoviesContract.View {

    @Inject lateinit var moviesPresenter: MoviesPresenter

    override fun show(movies: List<Movie>) {

    }


    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId())

        setSupportActionBar(toolbar)
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)
        container.adapter = mSectionsPagerAdapter

        container.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(container))

    }

    override fun layoutId() = R.layout.activity_main


    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            return MoviesFragment.PlaceholderFragment.newInstance(position + 1)
        }

        override fun getCount(): Int {
            return 3
        }
    }


}
