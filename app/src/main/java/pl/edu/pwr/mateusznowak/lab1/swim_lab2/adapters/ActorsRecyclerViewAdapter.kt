package pl.edu.pwr.mateusznowak.lab1.swim_lab2.adapters

import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_actor.view.*
import kotlinx.android.synthetic.main.item_photo.view.*
import kotlinx.android.synthetic.main.movie_list_row_left.view.*
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.R
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.helpers.ItemTouchHelperAdapter
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.models.Movie

/**
 * Created by Mateusz on 17.04.2017.
 */
class ActorsRecyclerViewAdapter(val actorsNames: List<String>) :
        RecyclerView.Adapter<ActorsRecyclerViewAdapter.ActorViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ActorViewHolder {
        val itemView = LayoutInflater
                .from(parent?.context)
                .inflate(R.layout.item_actor, parent, false)
        return ActorViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ActorViewHolder?, position: Int) {
        val itemView = holder!!.itemView
        itemView.tv_actorName.text = actorsNames[position]
    }

    override fun getItemCount() = actorsNames.size

    class ActorViewHolder(view: View) : RecyclerView.ViewHolder(view)
}