package com.example.pawel_piedel.mymovies.movies

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pawel_piedel.myapplication.R
import com.example.pawel_piedel.mymovies.MyMoviesApplication
import com.example.pawel_piedel.mymovies.data.model.model.Movie
import com.example.pawel_piedel.mymovies.data.model.model.MoviesCategory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_movies.*
import javax.inject.Inject

/**
 * Created by Pawel_Piedel on 07.11.2017.
 */
class MoviesFragment : Fragment() {
    @Inject lateinit var moviesViewModel: MoviesViewModel

    var subscriptions: CompositeDisposable = CompositeDisposable()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        MyMoviesApplication[context].component.inject(this)
        return inflater?.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onResume() {
        Log.d(LOG_TAG, "On resume")
        super.onResume()
        bindMovies(arguments.get(KEY) as MoviesCategory)
    }

    fun bindMovies(movieCategory: MoviesCategory) {
        when (movieCategory) {
            MoviesCategory.POPULAR -> {
                subscriptions.add(moviesViewModel.loadPopularMovies()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({ showMovies(it.results) }, { showError() }))
            }
            MoviesCategory.TOP_RATED -> {
                subscriptions.add(moviesViewModel.loadTopRatedMovies()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            showMovies(it.results)

                        }, {
                            showError()
                        }))
            }
            MoviesCategory.UPCOMING -> {
                subscriptions.add(moviesViewModel.loadUpcomingMovies()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            showMovies(it.results)
                        }, {
                            showError()
                        }))
            }
        }

    }

    fun showMovies(movies: List<Movie>) {
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView?.addItemDecoration(GridSpacingItemDecoration(2, 4, true))
        recyclerView.adapter = MoviesAdapter(context, movies)
    }


    fun showError() {
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = EmptyRecyclerViewAdapter(getString(R.string.we_cannot_download_data))
    }

    override fun onPause() {
        unbind()
        super.onPause()
    }


    fun unbind() {
        subscriptions.clear()
    }

    companion object {
        val LOG_TAG = "Movies Fragment"
        val KEY = "category"

        fun newInstance(movieCategory: MoviesCategory): MoviesFragment {
            val fragment = MoviesFragment()

            val args = Bundle()
            args.putSerializable(KEY, movieCategory)
            fragment.arguments = args

            return fragment
        }
    }
}