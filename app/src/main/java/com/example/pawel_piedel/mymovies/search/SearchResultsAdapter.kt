package com.example.pawel_piedel.mymovies.search

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pawel_piedel.myapplication.R
import com.example.pawel_piedel.mymovies.data.model.model.Movie
import com.example.pawel_piedel.mymovies.movies.OnItemClickListener
import kotlinx.android.synthetic.main.search_item.view.*

/**
 * Created by PPiedel on 20.01.2018.
 */
class SearchResultsAdapter(private val context: Context, private val onItemClickListener: OnItemClickListener) : RecyclerView.Adapter<SearchResultsAdapter.ViewHolder>() {
    private var movies: MutableList<Movie> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.search_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = movies[position].title
        holder.bindListener(movies[position], onItemClickListener)
    }

    fun addNewResults(newMovies: List<Movie>) {
        movies.clear()
        movies.addAll(newMovies)
        notifyDataSetChanged()
    }


    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val title = view.searchResultTitle

        fun bindListener(movie: Movie, listener: OnItemClickListener) {
            view.setOnClickListener({ listener.onItemClick(movie.id) })
        }
    }

}