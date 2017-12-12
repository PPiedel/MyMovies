package com.example.pawel_piedel.mymovies.movies

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.example.pawel_piedel.myapplication.R
import com.example.pawel_piedel.mymovies.data.model.model.Movie
import com.example.pawel_piedel.mymovies.data.source.remote.ApiService
import kotlinx.android.synthetic.main.item_movie.view.*

/**
 * Created by Pawel_Piedel on 03.11.2017.
 */
class MoviesAdapter(private val context: Context) : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    var movies: MutableList<Movie> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MovieViewHolder(layoutInflater.inflate(R.layout.item_movie, parent, false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]

        holder.title.text = movie.title
        holder.releaseYear.text = movie.releaseDate

        Glide.with(context)
                .load(ApiService.BASE_IMAGE_URL + movie.posterPath)
                .apply(RequestOptions.centerCropTransform())
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(holder.image)


    }

    override fun getItemCount(): Int = movies.size

    fun addMovies(newMovies: List<Movie>) {
        movies.addAll(newMovies)
        notifyDataSetChanged()
    }

    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image = view.thumbnail
        val title = view.title
        val releaseYear = view.releaseYear
    }
}