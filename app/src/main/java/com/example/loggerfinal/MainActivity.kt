package com.gtappdevelopers.kotlingfgproject

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.viewpager.widget.ViewPager
import com.example.loggerfinal.Adapter.MyAdapter
import com.google.android.material.tabs.TabLayout
import com.example.loggerfinal.R
import com.github.mikephil.charting.charts.LineChart
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_home.*
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.app.NotificationCompat
import com.google.android.material.textfield.TextInputEditText


class MainActivity : AppCompatActivity() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)

        tabLayout.addTab(tabLayout.newTab().setText("Home"))
        tabLayout.addTab(tabLayout.newTab().setText("Settings"))

        tabLayout.addTab(tabLayout.newTab().setText("Graph"))
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL

        val adapter = MyAdapter(this, supportFragmentManager, tabLayout.tabCount)
        viewPager.adapter = adapter

        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager.currentItem = tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}

        })
    }
}

