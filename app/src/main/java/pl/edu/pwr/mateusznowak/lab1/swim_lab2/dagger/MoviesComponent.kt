package pl.edu.pwr.mateusznowak.lab1.swim_lab2.dagger

import dagger.Component
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.activities.MovieDetailsActivity
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.activities.MoviesActivity
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.helpers.MoviesHelper
import javax.inject.Singleton

/**
 * Created by Mateusz on 01.05.2017.
 */
@Singleton
@Component(modules = arrayOf(MoviesModule::class))
interface MoviesComponent {

    fun inject(moviesActivity: MoviesActivity)
    fun inject(movieDetailsActivity: MovieDetailsActivity)

}