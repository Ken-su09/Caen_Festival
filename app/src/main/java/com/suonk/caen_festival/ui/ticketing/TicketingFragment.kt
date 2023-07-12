package com.suonk.caen_festival.ui.ticketing

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import com.suonk.caen_festival.R
import com.suonk.caen_festival.databinding.FragmentPlacesListBinding
import com.suonk.caen_festival.databinding.FragmentTicketingBinding
import com.suonk.caen_festival.ui.home.HomeFragment
import com.suonk.caen_festival.ui.main.MainActivity
import com.suonk.caen_festival.ui.places.PlacesListAdapter
import com.suonk.caen_festival.utils.viewBinding

class TicketingFragment : Fragment(R.layout.fragment_ticketing) {

    private val binding by viewBinding(FragmentTicketingBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupToolbar()
    }

    private fun setupToolbar() {
        if (requireActivity() is MainActivity) {
            (requireActivity() as MainActivity).setSupportActionBar(binding.toolbar)
            (requireActivity() as MainActivity).supportActionBar?.title = resources.getString(R.string.box_office_and_prices)
            (requireActivity() as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
            (requireActivity() as MainActivity).supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_custom_back_arrow)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.i("GetMenuItem", "item : $item")
        Log.i("GetMenuItem", "item.itemId : ${item.itemId}")
        Log.i("GetMenuItem", "android.R.id.home : ${android.R.id.home}")
        return when (item.itemId) {
            android.R.id.home -> {
                if (requireActivity() is MainActivity) {
                    requireActivity().supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HomeFragment(), tag)
                        .addToBackStack(null).commit()
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}