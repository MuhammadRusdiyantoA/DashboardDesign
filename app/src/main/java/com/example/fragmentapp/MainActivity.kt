package com.example.fragmentapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.fragmentapp.fragment.AboutMeFragment
import com.example.fragmentapp.fragment.DashboardFragment
import com.example.fragmentapp.fragment.ProjectsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        val dashboardFragment = DashboardFragment()
        val projectsFragment = ProjectsFragment()
        val aboutmeFragment = AboutMeFragment()

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.nav)

        //membuat fragment home menjadi default
        makeCurrentFragment(dashboardFragment)

        bottomNavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.dashboard -> makeCurrentFragment(dashboardFragment)
                R.id.projects -> makeCurrentFragment(projectsFragment)
                R.id.about -> makeCurrentFragment(aboutmeFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame_nav, fragment)
            commit()
        }
    }
}