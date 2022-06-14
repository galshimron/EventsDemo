package com.gs.eventsdemo.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.gs.eventsdemo.R
import com.gs.eventsdemo.ui.eventlist.EventsListFragment
import com.gs.eventsdemo.ui.schedule.ScheduleFragment
import java.lang.IllegalArgumentException

class MainScreenViewPagerAdapter(val context: Context, supportFragmentManager: FragmentManager): FragmentPagerAdapter(supportFragmentManager , BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> EventsListFragment()
            1 -> ScheduleFragment()
            else -> throw IllegalArgumentException("Invalid Item MainScreenViewPagerAdapter getItem")
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> context.getString(R.string.events)
            1 -> context.getString(R.string.schedule)
            else -> throw IllegalArgumentException("Invalid position MainScreenViewPagerAdapter getPageTitle")

        }
    }

}
