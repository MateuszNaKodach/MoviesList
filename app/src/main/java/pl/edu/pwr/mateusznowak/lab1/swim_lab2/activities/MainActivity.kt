package pl.edu.pwr.mateusznowak.lab1.swim_lab2.activities

import android.Manifest
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_main.*
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.R
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.adapters.MoviesRecyclerViewAdapter
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.helpers.PermissionsHelper
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.models.Movie
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.retrofit.MoviesCalls

class MainActivity : AppCompatActivity() {

    companion object {
        private val INTERNET_PERMISSION_CODE = 1
    }


    private val moviesList = ArrayList<Movie>()
    private val moviesAdapter = MoviesRecyclerViewAdapter(moviesList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        downloadMoviesData()

        initMoviesSwipeRefreshLayout()
        initMoviesRecyclerView()
    }

    private fun initMoviesRecyclerView() {
        rv_movies.layoutManager = LinearLayoutManager(this)
        rv_movies.adapter = moviesAdapter
    }

    private fun initMoviesSwipeRefreshLayout() {
        srl_movies.setOnRefreshListener {
            srl_movies.isRefreshing=true
            downloadMoviesData()
            srl_movies.isRefreshing=false
        }
    }

    fun downloadMoviesData(){
        moviesList.clear()

        val moviesTitles = resources.getStringArray(R.array.starwars_movies)

        val downloadRunnable: Runnable = Runnable {
            for (title in moviesTitles)
                MoviesCalls.getMovieByTitle(title)
                        .cache()
                        .subscribe(
                                { m ->
                                    moviesList.add(m)
                                },
                                { showMoviesDownloadError() }
                        )
        }

        val downloadThread = Thread(downloadRunnable)
        downloadThread.start()
        downloadThread.join()
        sortMoviesListByYear()

        moviesAdapter.notifyDataSetChanged()
    }

    fun sortMoviesListByYear(){
        moviesList.sortBy { it.year.toInt() }
    }

    private fun showMoviesDownloadError() {
        Toast.makeText(baseContext,R.string.download_error,Toast.LENGTH_SHORT).show()
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private fun askForInternetPermission(){
        PermissionsHelper.requestPermission(
                this,
                R.string.internet_permission_request,
                R.string.internet_permission_body,
                Array<String>(1){Manifest.permission.INTERNET},
                INTERNET_PERMISSION_CODE)
    }

}
