package com.example.pawel_piedel.mymovies.ui.movies.popular


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pawel_piedel.mymovies.MyMoviesApplication
import com.example.pawel_piedel.mymovies.R
import com.example.pawel_piedel.mymovies.data.model.Movie
import com.example.pawel_piedel.mymovies.injection.component.DaggerAppComponent
import com.example.pawel_piedel.mymovies.injection.module.AppModule
import com.example.pawel_piedel.mymovies.ui.movies.MoviesAdapter
import com.example.pawel_piedel.mymovies.ui.movies.MoviesViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_movies.*
import javax.inject.Inject


class PopularFragment : Fragment() {

    @Inject lateinit var moviesViewModel: MoviesViewModel

    private val subscriptions = CompositeDisposable()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        MyMoviesApplication[context].component.inject(this)
        return inflater?.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onResume() {
        super.onResume()
        bindPopularMovies()
    }

    override fun onPause() {
        unbind()
        super.onPause()
    }


    fun bindPopularMovies() {
        subscriptions.add(moviesViewModel.loadPopularMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext { moviesResponse -> Log.d(LOG_TAG,moviesResponse.toString()) }
                .subscribe({ moviesResponse ->
                    showMovies(moviesResponse.results)
                }, {
                    showError()
                }))
    }

    fun showMovies(movies: List<Movie>) {
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = MoviesAdapter(context, movies)

    }

    fun showError() {

    }

    fun unbind() {
        subscriptions.clear()
    }

    companion object {
        val LOG_TAG = "Popular Fragment"

        fun newInstance(): PopularFragment {
            return PopularFragment()
        }
    }

}
