package com.suonk.caen_festival.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.suonk.caen_festival.R
import com.suonk.caen_festival.databinding.FragmentHomeBinding
import com.suonk.caen_festival.ui.main.MainActivity
import com.suonk.caen_festival.ui.prepare_your_trip.PrepareYourTripFragment
import com.suonk.caen_festival.ui.ticketing.TicketingFragment
import com.suonk.caen_festival.utils.viewBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.switchToMenu.setOnClickListener {
            binding.mainLayout.visibility = View.VISIBLE
            binding.appIcon.visibility = View.GONE
            binding.switchToMenu.visibility = View.GONE
        }

        binding.switchToHome.setOnClickListener {
            binding.mainLayout.visibility = View.GONE
            binding.appIcon.visibility = View.VISIBLE
            binding.switchToMenu.visibility = View.VISIBLE
        }

        binding.boxOfficeAndPricesLayout.setOnClickListener {
            if (requireActivity() is MainActivity) {
                requireActivity().supportFragmentManager.beginTransaction().replace(R.id.fragment_container, TicketingFragment(), tag)
                    .addToBackStack(null).commit()
            }
        }

        binding.prepareYourTripLayout.setOnClickListener {
            if (requireActivity() is MainActivity) {
                requireActivity().supportFragmentManager.beginTransaction().replace(R.id.fragment_container, PrepareYourTripFragment(), tag)
                    .addToBackStack(null).commit()
            }
        }
    }
}