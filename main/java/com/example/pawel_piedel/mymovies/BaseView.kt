package com.example.pawel_piedel.mymovies

import com.example.pawel_piedel.mymovies.movies.MoviesContract


/**
 * Created by Pawel_Piedel on 29.10.2017.
 */
interface BaseView<T>{
    var presenter : T
}