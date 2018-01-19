package com.example.pawel_piedel.mymovies.search

import android.app.ListActivity
import android.os.Bundle
import com.example.pawel_piedel.myapplication.R
import android.app.SearchManager
import android.content.Intent
import timber.log.Timber


class SearchActivity : ListActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search);

        handleIntent(intent);
    }

    override fun onNewIntent(intent: Intent) {
        setIntent(intent)
        handleIntent(intent)
    }

    private fun handleIntent(intent: Intent) {
        if (Intent.ACTION_SEARCH == intent.action) {
            val query = intent.getStringExtra(SearchManager.QUERY)
            searchForResults(query)
        }
    }

    fun searchForResults(query: String) {
        Timber.d("Search for results with query : $query")
    }
}
