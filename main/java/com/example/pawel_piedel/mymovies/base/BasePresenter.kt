package com.example.pawel_piedel.mymovies.base

/**
 * Base class that implements the Presenter interface and provides a base implementation for
 * attachView() and detachView(). It also handles keeping a reference to the view that
 * can be accessed from the children classes by calling getView().
 */
open class BasePresenter<T : BaseView> : Presenter<T> {

    var view: T? = null
        private set

    override fun attachView(mvpView: T) {
        this.view = mvpView
    }

    override fun detachView() {
        view = null
    }

}

