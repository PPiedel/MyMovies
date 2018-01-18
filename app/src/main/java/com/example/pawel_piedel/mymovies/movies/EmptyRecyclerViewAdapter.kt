package com.example.pawel_piedel.mymovies.movies

/**
 * Created by Pawel_Piedel on 08.11.2017.
 */
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.pawel_piedel.myapplication.R
import kotlinx.android.synthetic.main.empty_list.view.*

class EmptyRecyclerViewAdapter(private val mMessage: String?) : RecyclerView.Adapter<EmptyRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.empty_list, parent, false)
        val viewHolder = ViewHolder(view)

        viewHolder.message.text = mMessage

        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {}

    override fun getItemCount(): Int {
        return 1
    }

    inner class ViewHolder(mView: View) : RecyclerView.ViewHolder(mView) {
        val message: TextView = mView.empty_item_message

    }
}