package pl.edu.pwr.mateusznowak.lab1.swim_lab2.adapters

import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_list_row_left.view.*
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.R
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.helpers.ItemTouchHelperAdapter
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.models.Movie

/**
 * Created by Mateusz on 17.04.2017.
 */
class MovieRecyclerViewAdapter(val moviesList:MutableList<Movie>) :
        RecyclerView.Adapter<MovieRecyclerViewAdapter.MovieViewHolder>(),
        ItemTouchHelperAdapter {

    companion object{
        val MOVIE_ITEM_LEFT_VIEW_TYPE = 1;
        val MOVIE_ITEM_RIGHT_VIEW_TYPE = 2;
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MovieViewHolder {

        val itemLayoutId:Int =
                if(viewType == MOVIE_ITEM_LEFT_VIEW_TYPE)
                    R.layout.movie_list_row_left
                else
                    R.layout.movie_list_row_right

        val itemView = LayoutInflater
                .from(parent?.context)
                .inflate(itemLayoutId, parent,false)

        return MovieViewHolder(itemView)
    }

    override fun getItemViewType(position: Int): Int {
        return if(position%2==0) MOVIE_ITEM_LEFT_VIEW_TYPE else MOVIE_ITEM_RIGHT_VIEW_TYPE
    }

    override fun onBindViewHolder(holder: MovieViewHolder?, position: Int) {

        val itemView = holder!!.itemView

        itemView.tv_title.text = moviesList[position].title
        itemView.tv_genre.text = moviesList[position].genre
        itemView.tv_year.text = moviesList[position].year

        Picasso.with(itemView.context)
                .load(Uri.parse(moviesList[position].poster))
                .error(R.drawable.no_picutre)
                .into(itemView.iv_poster)
    }

    override fun getItemCount() = moviesList.size

    override fun onItemDismiss(position: Int) {
        moviesList.removeAt(position);
        notifyItemRemoved(position);
    }

    class MovieViewHolder(view:View) : RecyclerView.ViewHolder(view)
}