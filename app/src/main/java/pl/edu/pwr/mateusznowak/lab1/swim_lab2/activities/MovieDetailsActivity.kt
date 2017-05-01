package pl.edu.pwr.mateusznowak.lab1.swim_lab2.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import pl.edu.pwr.mateusznowak.lab1.swim_lab2.R
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.models.Movie
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.retrofit.MoviesCalls

class MovieDetailsActivity : AppCompatActivity() {

    companion object{
        val MOVIE_TITLE_EXTRA = "pl.edu.pwr.mateusznowak.lab1.swim_lab2.MOVIE_TITLE_EXTRA";
    }

    private var movie: Movie? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        receiveMovieData()
    }

    private fun receiveMovieData(){

    }
}
