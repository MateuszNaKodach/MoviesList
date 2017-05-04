package pl.edu.pwr.mateusznowak.lab1.swim_lab2.fragments


import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_main_movie_info.*
import kotlinx.android.synthetic.main.fragment_main_movie_info.view.*
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.MoviesApp

import pl.edu.pwr.mateusznowak.lab1.swim_lab2.R
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.activities.MovieDetailsActivity
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.helpers.MoviesHelper
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.models.Movie
import javax.inject.Inject


class MainMovieInfoFragment private constructor() : Fragment() {

    companion object{
        fun newInstance(movieTitle: String):MainMovieInfoFragment{
            val mainMovieInfoFragment = MainMovieInfoFragment()
            val argumentsBundle = Bundle()
            argumentsBundle.putString(MovieDetailsActivity.MOVIE_TITLE_ARG, movieTitle);
            mainMovieInfoFragment.arguments = argumentsBundle
            return mainMovieInfoFragment
        }
    }

    @Inject
    lateinit var moviesHelper: MoviesHelper

    private var movie: Movie? = null

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

    private fun initDaggerDependencyInjection() {
        MoviesApp.moviesComponent.inject(this)
    }

    private fun receiveMovieData(){
        movie = moviesHelper.findMovieByTitle(arguments.getString(MovieDetailsActivity.MOVIE_TITLE_ARG))
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
