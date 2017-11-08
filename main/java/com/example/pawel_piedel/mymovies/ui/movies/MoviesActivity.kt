package com.example.pawel_piedel.mymovies.ui.movies

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import com.example.pawel_piedel.mymovies.R
import com.example.pawel_piedel.mymovies.data.model.MoviesCategory
import kotlinx.android.synthetic.main.activity_main.*


class MoviesActivity : AppCompatActivity() {
    private var tabsPagerAdapter: TabsPagerAdapter

    init {
        tabsPagerAdapter = TabsPagerAdapter(supportFragmentManager)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupTabs()

    }

    private fun setupTabs() {
        setSupportActionBar(toolbar)
        tabsPagerAdapter.addFragment(MoviesFragment.newInstance(MoviesCategory.POPULAR), getString(R.string.popular))
        tabsPagerAdapter.addFragment(MoviesFragment.newInstance(MoviesCategory.TOP_RATED), getString(R.string.top_rated))
        tabsPagerAdapter.addFragment(MoviesFragment.newInstance(MoviesCategory.UPCOMING), getString(R.string.upcoming))
        viewpager.adapter = tabsPagerAdapter
        tabs.setupWithViewPager(viewpager)
    }


    inner class TabsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
        private var fragments: MutableList<Pair<Fragment, String>> = ArrayList()

        override fun getItem(position: Int): Fragment {
            return fragments[position].first
        }

        override fun getCount(): Int {
            return fragments.size
        }

        fun addFragment(fragment: Fragment, title: String) {
            fragments.add(Pair(fragment, title))
        }

        override fun getPageTitle(position: Int): CharSequence {
            return fragments[position].second
        }
    }


}
