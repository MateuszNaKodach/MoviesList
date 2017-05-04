package pl.edu.pwr.mateusznowak.lab1.swim_lab2.adapters

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_list_row_left.view.*
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.R


/**
 * Created by Mateusz on 05.05.2017.
 */
class ImagesAdapter(val imagesUrls:List<String>):BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val imageView: ImageView
        if (convertView == null) {
            imageView = ImageView(parent?.context)
            imageView.layoutParams = ViewGroup.LayoutParams(85,85)
            imageView.scaleType = ImageView.ScaleType.CENTER_CROP
            imageView.setPadding(8, 8, 8, 8)
        } else {
            imageView = convertView as ImageView
        }

        Picasso.with(parent?.context)
                .load(Uri.parse(imagesUrls[position]))
                .error(R.drawable.no_picutre)
                .into(imageView)

        return imageView
    }

    override fun getItem(position: Int): String = imagesUrls[position]

    override fun getItemId(position: Int): Long = 0

    override fun getCount(): Int = imagesUrls.size
}