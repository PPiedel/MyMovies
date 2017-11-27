package com.example.pawel_piedel.mymovies.data.model.model

import io.requery.Entity

/**
 * Created by Pawel_Piedel on 30.10.2017.
 */
@Entity
enum class MoviesCategory {
    TOP_RATED, UPCOMING, POPULAR, NOT_KNOWN
}
