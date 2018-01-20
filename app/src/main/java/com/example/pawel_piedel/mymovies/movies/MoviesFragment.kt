package com.example.pawel_piedel.mymovies.movies

import android.app.ProgressDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pawel_piedel.myapplication.R
import com.example.pawel_piedel.mymovies.MyMoviesApplication
import com.example.pawel_piedel.mymovies.data.model.model.Movie
import com.example.pawel_piedel.mymovies.data.model.model.MoviesCategory
import com.example.pawel_piedel.mymovies.movie_details.MovieDetailsActivity
import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_movies.*
import timber.log.Timber
import javax.inject.Inject


/**
 * Created by Pawel_Piedel on 07.11.2017.
 */
class MoviesFragment : Fragment() {
    @Inject lateinit var moviesViewModel: MoviesViewModel
    private lateinit var adapter: MoviesAdapter
    private var progressDialog: ProgressDialog? = null
    private var subscriptions: CompositeDisposable = CompositeDisposable()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupAdapter()

        setupRecyclerView()

        val rxPermissions = RxPermissions(this.activity);
        moviesViewModel.onPermissionsAvailable(rxPermissions)
                .subscribe {
                    loadMovies()
                    bindLoadingIndicator()
                }
    }

    private fun setupAdapter() {
        adapter = MoviesAdapter(context, object : OnItemClickListener {
            override fun onItemClick(movieId: Int) {
                onMovieClicked(movieId)
            }
        })
    }

    private fun setupRecyclerView() {
        recyclerView.adapter = adapter

        val layoutManager = GridLayoutManager(context, 2)
        recyclerView.layoutManager = layoutManager
        recyclerView.addItemDecoration(GridSpacingItemDecoration(2, 4, true))

        setupRecyclerViewOnLoadMore(layoutManager)
    }

    private fun onMovieClicked(movieId: Int) {
        val intent = Intent(context, MovieDetailsActivity::class.java)
        intent.putExtra(MOVIE_ID, movieId)
        startActivity(intent)
    }


    private fun setupRecyclerViewOnLoadMore(layoutManager: GridLayoutManager) {
        recyclerView.addOnScrollListener(object : EndlessRecyclerViewScrollListener(layoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView?) {
                loadMovies(page + 1)
                Timber.d("On load more, page : " + page)
            }

        })
    }


    private fun loadMovies(page: Int = 1) {
        subscriptions.add(moviesViewModel.loadMovies(arguments.get(KEY) as MoviesCategory, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ showMovies(it) }, { t: Throwable? -> showError(t) }
                ))
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        MyMoviesApplication[context].component.inject(this)
        return inflater?.inflate(
                R.layout.fragment_movies, container, false)
    }

    fun bindLoadingIndicator() {
        subscriptions.add(moviesViewModel.loadingIndicator
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ setLoadingIndicatorVisibility(it) }, { t: Throwable? -> Timber.e(t?.message) }))
    }

    fun showMovies(movies: List<Movie>) {
        adapter.addMovies(movies)
        adapter.notifyDataSetChanged()
    }


    fun showError(error: Throwable?) {
        Log.d(LOG_TAG, error?.message)
        val snackbar = Snackbar.make(this.activity.findViewById<View>(android.R.id.content), "Something went wrong. Please check your Internet connection.", Snackbar.LENGTH_LONG)
        snackbar.show()
    }

    fun setLoadingIndicatorVisibility(visible: Boolean) = if (visible) {
        showProgressDialog()
    } else {
        hideProgressDialog()
    }

    private fun showProgressDialog() {
        hideProgressDialog()
        progressDialog = ProgressDialog(context)
        progressDialog?.show()
        if (progressDialog?.window != null) {
            progressDialog?.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
        progressDialog?.setContentView(R.layout.progress_dialog)
        progressDialog?.isIndeterminate = true
        progressDialog?.setCancelable(false)
        progressDialog?.setCanceledOnTouchOutside(false)
    }

    fun hideProgressDialog() {
        if (progressDialog != null && progressDialog!!.isShowing) {
            progressDialog?.cancel()
        }
    }

    override fun onPause() {
        unbind()
        super.onPause()
    }


    fun unbind() {
        subscriptions.clear()
    }

    companion object {
        const val LOG_TAG = "Movies Fragment"
        const val MOVIE_ID = "id"
        const val KEY = "CATEGORY"

        fun newInstance(movieCategory: MoviesCategory): MoviesFragment {
            val fragment = MoviesFragment()

            val args = Bundle()
            args.putSerializable(KEY, movieCategory)
            fragment.arguments = args

            return fragment
        }
    }
}