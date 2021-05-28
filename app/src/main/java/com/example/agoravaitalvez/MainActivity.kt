package com.example.agoravaitalvez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.agoravaitalvez.fragments.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        val homeFragment = HomeFragment()
        val peopleFragment = PeopleFragment()
        val configFragment = ConfigFragment()

        makeCurrentFragment(homeFragment)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.ic_home -> makeCurrentFragment(homeFragment)
                R.id.ic_people -> makeCurrentFragment(peopleFragment)
                R.id.ic_settings -> makeCurrentFragment(configFragment)
            }
            true
        }



    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply { replace(R.id.fl_content, fragment)
        commit()
        }

}

