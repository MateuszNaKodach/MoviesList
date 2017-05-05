package pl.edu.pwr.mateusznowak.lab1.swim_lab2.fragments


import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_main_movie_info.*

import pl.edu.pwr.mateusznowak.lab1.swim_lab2.R


class MainMovieFragment : MovieInfoFragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return getFragmentView(inflater,container,savedInstanceState,R.layout.fragment_main_movie_info)
    }

    override fun initUserInterface(){
        initMoviePoster()
        initMovieDescription()
    }

    private fun initMoviePoster() {
        Picasso.with(context)
                .load(Uri.parse(movie?.poster))
                .error(R.drawable.no_picutre)
                .into(iv_poster)
    }

    private fun initMovieDescription(){
        tv_description.text = movie?.plot
        tv_year.text = movie?.year
        tv_genre.text = movie?.genre
        tv_director.text = movie?.director
    }


}
