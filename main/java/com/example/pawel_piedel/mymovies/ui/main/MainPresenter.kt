package com.example.pawel_piedel.mymovies.ui.main

import android.util.Log
import com.example.pawel_piedel.mymovies.data.model.MoviesCategory
import com.example.pawel_piedel.mymovies.data.model.MoviesCategory.TOP_RATED
import com.example.pawel_piedel.mymovies.data.source.MoviesDataSource
import com.example.pawel_piedel.mymovies.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


/**
 * Created by Pawel_Piedel on 30.10.2017.
 */
class MainPresenter @Inject
constructor(val moviesDataSource: MoviesDataSource) : BasePresenter<MainContract.View>(), MainContract.Presenter {











    companion object {
        val LOG_TAG = MainPresenter::class.java.simpleName
    }
}