package pl.edu.pwr.mateusznowak.lab1.swim_lab2.adapters

import android.content.Context
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_list_row.view.*
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.R
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.models.Movie

/**
 * Created by Mateusz on 17.04.2017.
 */
class MoviesRecyclerViewAdapter(val moviesList:List<Movie>) : RecyclerView.Adapter<MoviesRecyclerViewAdapter.MovieViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MovieViewHolder {
        val itemView = LayoutInflater
                .from(parent?.context)
                .inflate(R.layout.movie_list_row, parent,false)

        return MovieViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MovieViewHolder?, position: Int) {

        val itemView = holder!!.itemView

        itemView.tv_title.text = moviesList.get(position).title
        itemView.tv_genre.text = moviesList.get(position).genre
        itemView.tv_year.text = moviesList.get(position).year

        Picasso.with(itemView.context)
                .load(Uri.parse(moviesList.get(position).poster))
                .error(R.drawable.no_picutre)
                .into(itemView.iv_poster)
    }

    override fun getItemCount() = moviesList.size

    class MovieViewHolder(view:View) : RecyclerView.ViewHolder(view)
}