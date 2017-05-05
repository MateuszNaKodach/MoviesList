package pl.edu.pwr.mateusznowak.lab1.swim_lab2.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_movie_photos.*
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.R
import android.support.v7.widget.GridLayoutManager
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.adapters.ImagesRecyclerViewAdapter


class MoviePhotosFragment : MovieInfoFragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return getFragmentView(inflater, container, savedInstanceState, R.layout.fragment_movie_photos)
    }

    override fun initUserInterface() {
        initMoviePhotosGridView()
    }

    private fun initMoviePhotosGridView() {
        rv_moviePhotos.layoutManager = GridLayoutManager(this.activity,3)
        rv_moviePhotos.adapter = ImagesRecyclerViewAdapter(moviesHelper.dummyMoviesUrls)
    }

}

