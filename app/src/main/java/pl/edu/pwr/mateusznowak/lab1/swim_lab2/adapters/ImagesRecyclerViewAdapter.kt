package pl.edu.pwr.mateusznowak.lab1.swim_lab2.adapters

import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_photo.view.*
import kotlinx.android.synthetic.main.movie_list_row_left.view.*
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.R
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.helpers.ItemTouchHelperAdapter
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.models.Movie

/**
 * Created by Mateusz on 17.04.2017.
 */
class ImagesRecyclerViewAdapter(val imagesUrls:List<String>) :
        RecyclerView.Adapter<ImagesRecyclerViewAdapter.ImageViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ImageViewHolder {
        val itemView = LayoutInflater
                .from(parent?.context)
                .inflate(R.layout.item_photo, parent,false)
        return ImageViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ImageViewHolder?, position: Int) {

        val itemView = holder!!.itemView

        Picasso.with(itemView.context)
                .load(Uri.parse(imagesUrls[position]))
                .error(R.drawable.no_picutre)
                .into(itemView.iv_photo)
    }

    override fun getItemCount() = imagesUrls.size

    class ImageViewHolder(view:View) : RecyclerView.ViewHolder(view)
}