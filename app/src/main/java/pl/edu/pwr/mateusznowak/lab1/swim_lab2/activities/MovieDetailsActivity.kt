package pl.edu.pwr.mateusznowak.lab1.swim_lab2.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.MoviesApp

import pl.edu.pwr.mateusznowak.lab1.swim_lab2.R
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.adapters.MoviesRecyclerViewAdapter
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.helpers.MoviesHelper
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.models.Movie
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.retrofit.MoviesCalls
import javax.inject.Inject

class MovieDetailsActivity : AppCompatActivity() {

    companion object{
        val MOVIE_POSITION_EXTRA = "pl.edu.pwr.mateusznowak.lab1.swim_lab2.MOVIE_POSITION_EXTRA";
    }

    @Inject
    lateinit var moviesHelper: MoviesHelper

    private var movie: Movie? = null;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_movie_details)
        initDaggerDependencyInjection()
        receiveMovieData()
    }

    private fun receiveMovieData(){
        movie = moviesHelper.moviesList[intent.getIntExtra(MOVIE_POSITION_EXTRA,0)]
    }

    private fun initDaggerDependencyInjection() {
        MoviesApp.moviesComponent.inject(this)
    }
}
