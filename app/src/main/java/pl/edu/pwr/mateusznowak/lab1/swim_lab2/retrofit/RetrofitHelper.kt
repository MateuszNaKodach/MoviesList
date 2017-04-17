package pl.edu.pwr.mateusznowak.lab1.swim_lab2.retrofit

import pl.edu.pwr.mateusznowak.lab1.swim_lab2.retrofit.interfaces.MoviesService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Mateusz on 17.04.2017.
 */
class RetrofitHelper {

    private val BASE_URL = "http://www.omdbapi.com"

    private var client:Retrofit?  = null

    fun getClient():Retrofit?{
        if(client==null) {
            client = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
        }
            return client;
    }

    fun getMoviesService():MoviesService?{
        return getClient()?.create(MoviesService::class.java)
    }

}