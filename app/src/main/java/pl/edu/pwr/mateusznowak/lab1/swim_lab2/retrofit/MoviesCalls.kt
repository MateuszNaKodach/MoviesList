package pl.edu.pwr.mateusznowak.lab1.swim_lab2.retrofit

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.models.Movie
import retrofit2.Call

/**
 * Created by Mateusz on 17.04.2017.
 */
object MoviesCalls {

    fun getMovieByTitle(title:String): Single<Movie>{
        return RetrofitHelper().getMoviesService()!!.getMovieByTitle(title)
    }
}