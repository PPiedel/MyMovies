package com.example.pawel_piedel.mymovies.movies

import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.MenuItem
import com.example.pawel_piedel.myapplication.R
import com.example.pawel_piedel.mymovies.data.model.model.MoviesCategory
import com.example.pawel_piedel.mymovies.search.SearchActivity
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber


class MoviesActivity : AppCompatActivity() {
    private var tabsPagerAdapter: TabsPagerAdapter

    init {
        tabsPagerAdapter = TabsPagerAdapter(supportFragmentManager)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupToolbar()

        setupTabs()

    }


    private fun setupToolbar() {
        setSupportActionBar(toolbar)
    }

    private fun setupTabs() {
        tabsPagerAdapter.addFragment(MoviesFragment.newInstance(MoviesCategory.POPULAR), getString(R.string.popular))
        tabsPagerAdapter.addFragment(MoviesFragment.newInstance(MoviesCategory.TOP_RATED), getString(R.string.top_rated))
        tabsPagerAdapter.addFragment(MoviesFragment.newInstance(MoviesCategory.UPCOMING), getString(R.string.upcoming))
        tabsPagerAdapter.addFragment(MoviesFragment.newInstance(MoviesCategory.NOW_PLAYING), getString(R.string.now_playing))
        viewpager.adapter = tabsPagerAdapter
        tabs.setupWithViewPager(viewpager)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_movies, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.search -> {
                startSearchActivity()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
                true
            }
        }
    }

    private fun startSearchActivity() {
        val intent = Intent(this, SearchActivity::class.java)
        startActivity(intent)
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
