package pl.edu.pwr.mateusznowak.lab1.swim_lab2.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.activity_main.*
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.R
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.adapters.MoviesRecyclerViewAdapter
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.models.Movie
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.retrofit.MoviesCalls
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.retrofit.RetrofitHelper
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.retrofit.interfaces.MoviesService

class MainActivity : AppCompatActivity() {

    private val moviesList = ArrayList<Movie>()
    private val moviesAdapter = MoviesRecyclerViewAdapter(moviesList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        downloadMoviesData()
        initMoviesRecyclerView()
    }

    fun downloadMoviesData(){
        val moviesTitles = resources.getStringArray(R.array.starwars_movies)

        for( title in moviesTitles)
            MoviesCalls.getMovieByTitle(title).subscribe({m -> moviesList.add(m)})


        moviesList.sortBy { it.year.toInt() }//(compareBy({it.year.toInt()}))
        moviesAdapter.notifyDataSetChanged()
    }

    private fun initMoviesRecyclerView() {
        rv_movies.layoutManager = LinearLayoutManager(this)
        rv_movies.adapter = moviesAdapter
    }


}
