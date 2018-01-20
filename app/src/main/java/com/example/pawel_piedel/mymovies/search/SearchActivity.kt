package com.example.pawel_piedel.mymovies.search

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.pawel_piedel.myapplication.R
import com.example.pawel_piedel.mymovies.MyMoviesApplication
import com.example.pawel_piedel.mymovies.data.model.model.Movie
import com.example.pawel_piedel.mymovies.movie_details.MovieDetailsActivity
import com.example.pawel_piedel.mymovies.movies.MoviesFragment
import com.example.pawel_piedel.mymovies.movies.OnItemClickListener
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_search.*
import timber.log.Timber
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

        setupAdapter()

        setupRecyclerView()

        setupSearchView()
    }

    private fun setupSearchView(){
        searchView.setIconifiedByDefault(false)
    }

    private fun setupAdapter() {
        adapter = SearchResultsAdapter(this, object : OnItemClickListener {
            override fun onItemClick(movieId: Int) {
                Timber.d("On movie search result clicked.")
                startDetailsActivity(movieId)
            }
        })
    }

    fun startDetailsActivity(movieId: Int) {
        val intent = Intent(this, MovieDetailsActivity::class.java)
        intent.putExtra(MoviesFragment.MOVIE_ID, movieId)
        startActivity(intent)
    }

    private fun setupRecyclerView() {
        searchResultsRecyclerView.adapter = adapter
        searchResultsRecyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onResume() {
        super.onResume()
        observeSearchView()
    }

    fun observeSearchView() {
        RxSearch.fromSearchView(searchView)
                .filter { query -> query.length >= MIN_QUERY_LENGTH }
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
                        .subscribe { movies -> showResults(movies) }
        )
    }

    fun showResults(movies: List<Movie>) {
        if (movies.isEmpty()){

        }
        adapter.addNewResults(movies)
    }

    override fun onPause() {
        super.onPause()
        subscriptions.clear()
    }

    companion object {
        private const val MIN_QUERY_LENGTH = 3
    }
}
