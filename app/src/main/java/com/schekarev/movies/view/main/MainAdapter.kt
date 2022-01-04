package com.schekarev.movies.view.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.schekarev.movies.model.entity.Movie
import com.schekarev.movies.R
import com.squareup.picasso.Picasso

class MainAdapter(private val onListItemClickListener: OnListItemClickListener) :
    RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private var data: List<Movie> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<Movie>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_main_recycler_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) =
        holder.bind(data[position])

    override fun getItemCount() = data.size

    inner class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(data: Movie) {
            if (layoutPosition != RecyclerView.NO_POSITION) {
                Picasso
                    .get()
                    .load(data.imageUrl)
                    .into(itemView.findViewById<ImageView>(R.id.image_view))

                itemView.setOnClickListener { openInNewWindow(data) }
            }
        }
    }

    private fun openInNewWindow(data: Movie) {
        onListItemClickListener.onItemClick(data)
    }

    interface OnListItemClickListener {
        fun onItemClick(data: Movie)
    }
}
