package pl.edu.pwr.mateusznowak.lab1.swim_lab2.helpers

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.models.Movie
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.retrofit.MoviesCalls
import java.util.*
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

    val dummyMoviesUrls = Arrays.asList(
                "http://www.planwallpaper.com/static/images/bored-star-wars-vii-650.jpg",
                "http://www.planwallpaper.com/static/images/star_wars_battlefront_dice.0.jpg",
                "https://s-media-cache-ak0.pinimg.com/originals/3d/2b/c4/3d2bc4e6e030b4ca340652d1b7ff121a.jpg",
                "https://s-media-cache-ak0.pinimg.com/736x/76/b6/a4/76b6a4239e100bcffe2a0d53fdacbffd.jpg",
                "https://s.aolcdn.com/hss/storage/midas/d07f8419800faacf4ed586ccfb5d6812/203345880/image.jpg",
                "http://www.kulturalnaplaneta.pl/wp-content/uploads/2016/01/rendition1.img_-1.jpg")

    val dummyActorsNames = Arrays.asList(
            "Mark Hamill",
            "Carie Fisher",
            "Harrison Ford",
            "Anthony Daniels",
            "Peter Mayhew",
            "Ewan McGregor"
    )

}