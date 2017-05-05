package pl.edu.pwr.mateusznowak.lab1.swim_lab2.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.MoviesApp
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.helpers.MoviesHelper
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.models.Movie
import javax.inject.Inject

/**
 * Created by Mateusz on 05.05.2017.
 */
abstract class MovieInfoFragment : Fragment() {

    companion object {
        const val MOVIE_TITLE_ARG = "pl.edu.pwr.mateusznowak.lab1.swim_lab2.MOVIE_TITLE_ARG";

        fun <E : Fragment> newInstance(clazz: Class<E>, movieTitle: String): E {
            val fragment = clazz.newInstance()
            val argumentsBundle = Bundle()
            argumentsBundle.putString(MovieInfoFragment.MOVIE_TITLE_ARG, movieTitle);
            fragment.arguments = argumentsBundle
            return fragment
        }
    }

    @Inject
    lateinit var moviesHelper: MoviesHelper

    protected var movie: Movie? = null


    protected fun getFragmentView(inflater: LayoutInflater?, container: ViewGroup?,
                                  savedInstanceState: Bundle?, fragmentLayoutId: Int): View {
        val view = inflater!!.inflate(fragmentLayoutId, container, false)
        initDaggerDependencyInjection()
        receiveMovieData()
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUserInterface()
    }

    abstract protected fun initUserInterface();

    protected fun initDaggerDependencyInjection() {
        MoviesApp.moviesComponent.inject(this)
    }

    protected fun receiveMovieData() {
        movie = moviesHelper.findMovieByTitle(arguments.getString(MOVIE_TITLE_ARG))
    }


}