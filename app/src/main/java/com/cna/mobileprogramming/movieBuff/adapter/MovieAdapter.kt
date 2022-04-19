package com.cna.mobileprogramming.movieBuff.adapter

import android.R
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cna.mobileprogramming.foodie.databinding.AdapterMovieBinding
import com.cna.mobileprogramming.movieBuff.model.Movie
import com.cna.mobileprogramming.movieBuff.ui.MainActivity
import com.cna.mobileprogramming.movieBuff.util.ValidationUtil


class MovieAdapter : RecyclerView.Adapter<MainViewHolder>() {

    var movieList = mutableListOf<Movie>()

    fun setMovies(movies: List<Movie>) {
        this.movieList = movies.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterMovieBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {

        val movie = movieList[position]
        if (ValidationUtil.validateMovie(movie)) {
            (movie.name + "\n" + movie.category).also { holder.binding.name.text = it }

            Glide.with(holder.itemView.context).load(movie.imageUrl).into(holder.binding.imageview)
        }
        holder.binding.name.setOnClickListener {
            Log.d("Test",holder.binding.name.text.toString())
            val name = movie.name
            val category = movie.category
        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}

class MainViewHolder(val binding: AdapterMovieBinding) : RecyclerView.ViewHolder(binding.root) {

}
