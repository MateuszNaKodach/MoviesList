package pl.edu.pwr.mateusznowak.lab1.swim_lab2.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import pl.edu.pwr.mateusznowak.lab1.swim_lab2.R


class MoviePhotosAndCastFragment : MovieInfoFragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return getFragmentView(inflater,container,savedInstanceState,R.layout.fragment_movie_photos_and_cast);
    }

    override fun initUserInterface() {
        initMoviePhotosFragment()
    }

    private fun initMoviePhotosFragment() {
        val photosFragment = MovieInfoFragment.newInstance(MoviePhotosFragment::class.java,movie!!.title)
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fr_moviePhotos, photosFragment)
        transaction.commit()
    }
}
