package pl.edu.pwr.mateusznowak.lab1.swim_lab2.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_movie_details.*
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.MoviesApp

import pl.edu.pwr.mateusznowak.lab1.swim_lab2.R
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.adapters.BaseFragmentPagerAdapter
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.fragments.MainMovieInfoFragment
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.helpers.MoviesHelper
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.models.Movie
import java.util.*
import javax.inject.Inject

class MovieDetailsActivity : AppCompatActivity() {

    companion object{
        val MOVIE_POSITION_EXTRA = "pl.edu.pwr.mateusznowak.lab1.swim_lab2.MOVIE_POSITION_EXTRA";
        val MOVIE_TITLE_ARG = "pl.edu.pwr.mateusznowak.lab1.swim_lab2.MOVIE_TITLE_ARG";
    }

    @Inject
    lateinit var moviesHelper: MoviesHelper

    lateinit private var movie: Movie


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        initDaggerDependencyInjection()
        receiveMovieData()
        initUserInterface()
    }

    private fun receiveMovieData(){
        movie = moviesHelper.moviesList[intent.getIntExtra(MOVIE_POSITION_EXTRA,0)]
    }

    private fun initDaggerDependencyInjection() {
        MoviesApp.moviesComponent.inject(this)
    }

    private fun initUserInterface(){
        initActivityTitle()
        initViewPager()
    }

    private fun initActivityTitle(){
        title = movie.title
    }

    private fun initViewPager(){
        vp_movieDetailsPager.adapter = BaseFragmentPagerAdapter(
                supportFragmentManager,
                Arrays.asList(MainMovieInfoFragment.newInstance(movie.title)))
    }
}
