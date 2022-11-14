package com.jasmeet.idealsofttask.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.jasmeet.idealsofttask.R
import com.jasmeet.idealsofttask.activities.MovieDetailsActivity
import com.jasmeet.idealsofttask.databinding.MovielistItemBinding


class MovieListAdapter(var mContext: Context,val list:List<com.jasmeet.myapplication_1.models.Result>):Adapter<MovieListAdapter.MovieListViewHolder>() {

    inner class MovieListViewHolder(view: View): ViewHolder(view) {
        val binding = MovielistItemBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        return  MovieListViewHolder(
            LayoutInflater.from(mContext)
            .inflate(
                R.layout.movielist_item,
                parent,
                false))
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        val item = list[position]

        holder.binding.tvTitle.text = item.title
        holder.binding.tvOverview.text = item.overview
        Glide.with(mContext)
            .load("https://image.tmdb.org/t/p/w500${item.poster_path}")
            .into(holder.binding.imageView)

        holder.itemView.setOnClickListener {
            val intent = Intent(mContext, MovieDetailsActivity::class.java)
            intent.putExtra("title",item.title) //
            intent.putExtra("overview",item.overview) //
            intent.putExtra("poster_path",item.poster_path) //
            intent.putExtra("release_date",item.release_date) //
            intent.putExtra("original_language",item.original_language)
            intent.putExtra("vote_average",item.vote_average)
            mContext.startActivity(intent)

        }



    }

    private fun openDialog() {

    }

    override fun getItemCount(): Int {
        return list.size
    }
}

