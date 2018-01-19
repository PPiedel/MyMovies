package com.example.pawel_piedel.mymovies.search

import android.support.v7.widget.SearchView
import io.reactivex.subjects.BehaviorSubject
import android.support.v4.widget.SearchViewCompat.setOnQueryTextListener
import io.reactivex.Observable


/**
 * Created by PPiedel on 19.01.2018.
 */
class RxSearch {
    companion object {
        fun fromSearchView(searchView: SearchView): Observable<String> {
            val behaviourSubject: BehaviorSubject<String> = BehaviorSubject.create()

            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String): Boolean {
                    behaviourSubject.onComplete()
                    return true
                }

                override fun onQueryTextChange(newText: String): Boolean {
                    if (!newText.isEmpty()) {
                        behaviourSubject.onNext(newText)
                    }
                    return true
                }
            })

            return behaviourSubject
        }
    }
}