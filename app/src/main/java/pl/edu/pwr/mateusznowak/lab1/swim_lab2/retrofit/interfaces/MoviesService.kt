package pl.edu.pwr.mateusznowak.lab1.swim_lab2.retrofit.interfaces

import io.reactivex.Observable
import io.reactivex.Single
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.models.Movie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Created by Mateusz on 17.04.2017.
 */
interface MoviesService {

    @GET("/")
    fun getMovieByTitle(@Query("t") title:String):Single<Movie>
}