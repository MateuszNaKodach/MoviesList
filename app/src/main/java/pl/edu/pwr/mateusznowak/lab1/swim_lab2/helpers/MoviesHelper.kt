package pl.edu.pwr.mateusznowak.lab1.swim_lab2.helpers

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.models.Movie
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.retrofit.MoviesCalls
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Mateusz on 24.04.2017.
 */

class MoviesHelper{
    val moviesList = ArrayList<Movie>()

    fun downloadMoviesDataForTitles(moviesTitles: Array<String>){
        moviesList.clear()
        val downloadRunnable: Runnable = Runnable {
            for (title in moviesTitles)
                MoviesCalls.getMovieByTitle(title)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.newThread())
                        .cache()
                        .subscribe({ m -> moviesList.add(m) })
        }
        val downloadThread = Thread(downloadRunnable)
        downloadThread.start()
        downloadThread.join()
        sortMoviesListByYear();
    }

    fun findMovieByTitle(title:String):Movie? = moviesList.firstOrNull { movie -> movie.title==title }

    private fun sortMoviesListByYear(){
        moviesList.sortBy { it.year.toInt() }
    }

}