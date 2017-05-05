package pl.edu.pwr.mateusznowak.lab1.swim_lab2.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_movies.*
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.R
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.adapters.MovieRecyclerViewAdapter
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.listeners.RecyclerTouchListener
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.MoviesApp
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.helpers.BaseItemTouchHelperCallback
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.helpers.MoviesHelper
import javax.inject.Inject


class MoviesActivity : AppCompatActivity() {

    companion object {
        const private val INTERNET_PERMISSION_CODE = 1
    }

    @Inject
    lateinit var moviesHelper:MoviesHelper

    lateinit private var moviesAdapter: MovieRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)

        initDaggerDependencyInjection()
        showMoviesDataIfExists()
        initMoviesSwipeRefreshLayout()
        initMoviesRecyclerView()
    }

    private fun initDaggerDependencyInjection() {
        MoviesApp.moviesComponent.inject(this)
        moviesAdapter = MovieRecyclerViewAdapter(moviesHelper.moviesList)
    }

    private fun initMoviesRecyclerView() {
        rv_movies.layoutManager = LinearLayoutManager(this)
        rv_movies.adapter = moviesAdapter
        rv_movies.addOnItemTouchListener(RecyclerTouchListener(applicationContext,rv_movies,object: RecyclerTouchListener.ClickListener {
            override fun onClick(view: View?, position: Int) {
                val intent = Intent(applicationContext, MovieDetailsActivity::class.java)
                intent.putExtra(MovieDetailsActivity.MOVIE_POSITION_EXTRA,position)
                startActivity(intent)
            }

            override fun onLongClick(view: View?, position: Int) {
                toggleMovieLongClickIconVisibility(view)
            }

        }))

        ItemTouchHelper(BaseItemTouchHelperCallback(moviesAdapter)).attachToRecyclerView(rv_movies)
    }

    private fun toggleMovieLongClickIconVisibility(view: View?) {
        val longClickIcon: View? = view?.findViewById(R.id.iv_longClick)
        if(longClickIcon?.visibility == View.VISIBLE) {
            longClickIcon.visibility = View.GONE
        }else {
            longClickIcon?.visibility = View.VISIBLE
        }
    }

    private fun initMoviesSwipeRefreshLayout() {
        srl_movies.setOnRefreshListener {
            srl_movies.isRefreshing=true
            moviesAdapter.notifyDataSetChanged()
            srl_movies.isRefreshing=false
        }
    }

    fun showMoviesDataIfExists(){
        val moviesTitles = resources.getStringArray(R.array.starwars_movies)
        moviesHelper.downloadMoviesDataForTitles(moviesTitles)
        moviesAdapter.notifyDataSetChanged()
    }

    private fun showMoviesDownloadError() {
        Toast.makeText(baseContext,R.string.download_error,Toast.LENGTH_SHORT).show()
    }


}
