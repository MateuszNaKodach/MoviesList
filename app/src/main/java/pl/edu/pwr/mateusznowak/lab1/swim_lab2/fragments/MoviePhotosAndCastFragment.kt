package pl.edu.pwr.mateusznowak.lab1.swim_lab2.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import pl.edu.pwr.mateusznowak.lab1.swim_lab2.R


class MoviePhotosAndCastFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_movie_photos_and_cast, container, false)
    }

}
