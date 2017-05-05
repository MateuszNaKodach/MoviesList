package pl.edu.pwr.mateusznowak.lab1.swim_lab2.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.app.FragmentStatePagerAdapter

/**
 * Created by Mateusz on 05.05.2017.
 */
class BaseFragmentPagerAdapter(fragmentManager: FragmentManager, val fragmentsList: List<Fragment>)
    :FragmentStatePagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment = fragmentsList[position]

    override fun getCount(): Int = fragmentsList.size
}