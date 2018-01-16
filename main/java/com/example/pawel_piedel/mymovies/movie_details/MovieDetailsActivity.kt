package com.example.pawel_piedel.mymovies.movie_details

import android.Manifest
import android.os.Bundle
import android.support.v4.app.NavUtils
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.example.pawel_piedel.myapplication.R
import com.example.pawel_piedel.mymovies.MyMoviesApplication
import com.example.pawel_piedel.mymovies.data.model.model.Movie
import com.example.pawel_piedel.mymovies.data.source.remote.ApiService
import com.example.pawel_piedel.mymovies.movies.MoviesFragment
import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_details_view.*
import javax.inject.Inject

class MovieDetailsActivity : AppCompatActivity() {

    @Inject lateinit var movieDetailsViewModel: MovieDetailsViewModel

    val subscriptions: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_view)

        setupToolbar()

        MyMoviesApplication[applicationContext].component.inject(this)
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbarDetail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

    }


    override fun onResume() {
        super.onResume()

        val rxPermissions = RxPermissions(this);
        onPermissionsAvailable(rxPermissions)
                .subscribe {
                    bindMovieDetails()
                }

    }

    private fun onPermissionsAvailable(rxPermissions: RxPermissions) =
            rxPermissions
                    .request(Manifest.permission.INTERNET)

    fun bindMovieDetails() {
        val intent = intent
        val id: Int = intent.extras.getInt(MoviesFragment.MOVIE_ID)

        bindMovieDetails(id)

    }

    private fun bindMovieDetails(id: Int) {
        subscriptions.add(movieDetailsViewModel.loadMovieDetails(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ showMovieDetails(it) }, { error: Throwable? -> showError(error) }
                ))
    }

    fun showMovieDetails(movie: Movie?) {
        Log.d(LOG_TAG, movie.toString())
        loadMovieBackdrop(movie)
        releaseDate.text = movie?.releaseDate ?: "Unknown"
        originalLanguage.text = movie?.originalLanguage ?: "Unknown"
        durationTime.text = String.format("%s min", movie?.runtime)
        review.text = movie?.overview
        Log.d(LOG_TAG, "Movie title : " + movie?.title)
        collapsingToolbarLayout.title = movie?.title

    }

    private fun loadMovieBackdrop(movie: Movie?) {
        Glide.with(applicationContext)
                .load(ApiService.BASE_IMAGE_URL + movie?.backdropPath)
                .apply(RequestOptions.centerCropTransform())
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(movieBackdrop)
    }

    fun showError(error: Throwable?) {
        Log.d(LOG_TAG, error?.message)
    }

    override fun onPause() {
        super.onPause()
        subscriptions.clear()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.home -> {
                NavUtils.navigateUpFromSameTask(this);
                return true
            }

        }

        return super.onOptionsItemSelected(item)
    }

    companion object {
        const val LOG_TAG = "MovieDetailsActivity"
    }


}
