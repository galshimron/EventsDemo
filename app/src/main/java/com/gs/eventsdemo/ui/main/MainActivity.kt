package com.gs.eventsdemo.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.gs.eventsdemo.R
import com.gs.eventsdemo.databinding.ActivityMainBinding
import com.gs.eventsdemo.utils.formatDate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        val mainScreenViewPagerAdapter =
            MainScreenViewPagerAdapter(this@MainActivity, supportFragmentManager)

        val viewPager = activityMainBinding.viewPager
        viewPager.adapter =mainScreenViewPagerAdapter
        val tabLayout = activityMainBinding.tabLayout
        tabLayout.apply {
            setupWithViewPager(viewPager)
            getTabAt(0)?.setIcon(R.drawable.ic_event_24)
            getTabAt(1)?.setIcon(R.drawable.ic_schedule_24)
        }
    }
}