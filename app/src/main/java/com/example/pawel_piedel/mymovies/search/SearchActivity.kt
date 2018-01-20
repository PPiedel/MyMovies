package com.example.pawel_piedel.mymovies.search

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.pawel_piedel.myapplication.R
import com.example.pawel_piedel.mymovies.MyMoviesApplication
import com.example.pawel_piedel.mymovies.data.model.model.Movie
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_search.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class SearchActivity : AppCompatActivity() {
    private val subscriptions = CompositeDisposable()
    private lateinit var adapter: SearchResultsAdapter
    @Inject lateinit var searchViewModel: SearchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search);

        MyMoviesApplication[applicationContext].component.inject(this)

        adapter = SearchResultsAdapter(this)
        searchResultsRecyclerView.adapter = adapter
        searchResultsRecyclerView.layoutManager = LinearLayoutManager(this)

    }

    override fun onResume() {
        super.onResume()
        observeSearchView()
    }

    fun observeSearchView() {
        RxSearch.fromSearchView(searchView)
                .filter { query -> query.length > 1 }
                .debounce(300, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { query: String ->
                    performSearch(query)

                }
    }

    fun performSearch(query: String) {
        subscriptions.add(
                searchViewModel.loadSearchResults(query)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe { movies -> showMovies(movies) }
        )
    }

    fun showMovies(movies: List<Movie>) {
        adapter.addNewMovies(movies)
    }

    override fun onPause() {
        super.onPause()
        subscriptions.clear()

    }
}
