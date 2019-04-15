package com.universe.rodrf.peopletracking.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.universe.rodrf.peopletracking.Fragments.LocationHistoryFragment
import com.universe.rodrf.peopletracking.Fragments.MapFragment

class MyPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> MapFragment()
            1 -> LocationHistoryFragment()
            else -> MapFragment()
        }
    }

    override fun getCount(): Int {
        return 2

    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "Mapa"
            1 -> "Historial"
            else -> "Sin tab"
        }
    }

}