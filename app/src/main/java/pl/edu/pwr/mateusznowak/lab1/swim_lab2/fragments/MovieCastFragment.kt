package pl.edu.pwr.mateusznowak.lab1.swim_lab2.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_movie_photos.*
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.R
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_movie_cast.*
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.adapters.ActorsRecyclerViewAdapter
import pl.edu.pwr.mateusznowak.lab1.swim_lab2.adapters.ImagesRecyclerViewAdapter


class MovieCastFragment : MovieInfoFragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return getFragmentView(inflater, container, savedInstanceState, R.layout.fragment_movie_cast)
    }

    override fun initUserInterface() {
        initMovieCastRecyclerView()
    }

    private fun initMovieCastRecyclerView() {
        rv_movieCast.layoutManager = LinearLayoutManager(this.activity)
        rv_movieCast.adapter = ActorsRecyclerViewAdapter(moviesHelper.dummyActorsNames)
    }

}

