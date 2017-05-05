package pl.edu.pwr.mateusznowak.lab1.swim_lab2.fragments


import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_main_movie_info.*

import pl.edu.pwr.mateusznowak.lab1.swim_lab2.R


class MainMovieInfoFragment : MovieInfoFragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_main_movie_info, container, false)
        initDaggerDependencyInjection()
        receiveMovieData()
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUserInterface()
    }

    private fun initUserInterface(){
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
    }


}
