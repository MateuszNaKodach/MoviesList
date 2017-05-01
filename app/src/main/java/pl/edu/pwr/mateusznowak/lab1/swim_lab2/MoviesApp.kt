package pl.edu.pwr.mateusznowak.lab1.swim_lab2

import android.app.Application
import dagger.Component
import dagger.Module
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.dagger.DaggerMoviesComponent
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.dagger.MoviesComponent
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.dagger.MoviesModule

/**
 * Created by Mateusz on 17.04.2017.
 */
class MoviesApp() : Application() {

    companion object{
        lateinit var moviesComponent: MoviesComponent
    }

    override fun onCreate() {
        super.onCreate()
        moviesComponent = DaggerMoviesComponent.builder().moviesModule(MoviesModule()).build()
    }

}