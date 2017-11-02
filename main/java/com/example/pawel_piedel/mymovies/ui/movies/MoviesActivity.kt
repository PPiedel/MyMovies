package com.example.pawel_piedel.mymovies.ui.movies

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import com.example.pawel_piedel.mymovies.MyMoviesApplication
import com.example.pawel_piedel.mymovies.R
import com.example.pawel_piedel.mymovies.data.model.MoviesCategory
import kotlinx.android.synthetic.main.activity_main.*


class MoviesActivity : AppCompatActivity() {


    private var mTabsPagerAdapter: TabsPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        setSupportActionBar(toolbar)
        mTabsPagerAdapter = TabsPagerAdapter(supportFragmentManager)
        container.adapter = mTabsPagerAdapter

        container.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(container))

    }


    inner class TabsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            val fragment = MoviesFragment()
            val args = Bundle()
            args.putInt(MoviesFragment.ARG_OBJECT, position)
            fragment.arguments = args
            return fragment
        }

        override fun getCount(): Int {
            return TABS_COUNT
        }

        override fun getPageTitle(position: Int): CharSequence {
            var title : String = ""
            when (position) {
                0 -> title =  MoviesCategory.TOP_RATED.toString()
                1 -> title =  MoviesCategory.POPULAR.toString()
                2 -> title =  MoviesCategory.UPCOMING.toString()
            }
            return title
        }
    }

    companion object {
        val TABS_COUNT = 3
    }


}
