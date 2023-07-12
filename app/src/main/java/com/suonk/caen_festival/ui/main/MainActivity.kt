package com.suonk.caen_festival.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.suonk.caen_festival.R
import com.suonk.caen_festival.databinding.ActivityMainBinding
import com.suonk.caen_festival.ui.home.HomeFragment
import com.suonk.caen_festival.ui.my_festival.MyFestivalFragment
import com.suonk.caen_festival.ui.places.PlacesListFragment
import com.suonk.caen_festival.utils.viewBinding

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding { ActivityMainBinding.inflate(it) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HomeFragment(), "").addToBackStack(null).commit()

        setupBottomNavigationView()
    }

    //region ========================================================= TOOLBAR / BOTTOM NAV =========================================================

    private fun setupBottomNavigationView() {
        binding.bottomNavigation.menu.findItem(R.id.nav_home).isChecked = true
        binding.bottomNavigation.setOnItemSelectedListener { menuItem ->
            val fragmentToCommit = when (menuItem.itemId) {
                R.id.nav_program -> {
                    menuItem.isChecked = true
                    HomeFragment()
                }
                R.id.nav_show -> {
                    menuItem.isChecked = true
                    MyFestivalFragment()
                }
                R.id.nav_tickets -> {
                    menuItem.isChecked = true
                    HomeFragment()
                }
                R.id.nav_venues -> {
                    menuItem.isChecked = true
                    PlacesListFragment()
                }
                else -> {
                    menuItem.isChecked = true
                    HomeFragment()
                }
            }
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragmentToCommit, "").addToBackStack(null).commit()

            true
        }
    }

    //endregion

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HomeFragment(), "").addToBackStack(null).commit()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}