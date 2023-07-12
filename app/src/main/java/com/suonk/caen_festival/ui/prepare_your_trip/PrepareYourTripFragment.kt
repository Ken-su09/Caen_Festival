package com.suonk.caen_festival.ui.prepare_your_trip

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.suonk.caen_festival.R
import com.suonk.caen_festival.databinding.FragmentPrepareYourTripBinding
import com.suonk.caen_festival.ui.home.HomeFragment
import com.suonk.caen_festival.ui.main.MainActivity
import com.suonk.caen_festival.ui.ticketing.TicketingFragment
import com.suonk.caen_festival.utils.viewBinding

class PrepareYourTripFragment : Fragment(R.layout.fragment_prepare_your_trip) {

    private val binding by viewBinding(FragmentPrepareYourTripBinding::bind)

    private var carLayoutIsOpen = false
    private var busLayoutIsOpen = false
    private var trainLayoutIsOpen = false
    private var planeLayoutIsOpen = false
    private var boatLayoutIsOpen = false

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backIcon.setOnClickListener {
            if (requireActivity() is MainActivity) {
                requireActivity().supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HomeFragment(), tag)
                    .addToBackStack(null).commit()
            }
        }

        binding.carLayout.setOnClickListener {
            carLayoutIsOpen = !carLayoutIsOpen

            binding.carDescription.isVisible = carLayoutIsOpen
            binding.carDescription2.isVisible = carLayoutIsOpen
            binding.carDescription3.isVisible = carLayoutIsOpen
            binding.carDescription4.isVisible = carLayoutIsOpen
            binding.carDescription5.isVisible = carLayoutIsOpen
            binding.carDescription6.isVisible = carLayoutIsOpen
            binding.carDescription7.isVisible = carLayoutIsOpen
            binding.carDescription8.isVisible = carLayoutIsOpen
            binding.carDescription9.isVisible = carLayoutIsOpen
            binding.carDescription10.isVisible = carLayoutIsOpen
            binding.carDescription11.isVisible = carLayoutIsOpen
            binding.carDescription12.isVisible = carLayoutIsOpen
            binding.carDescription13.isVisible = carLayoutIsOpen
            binding.carDescription14.isVisible = carLayoutIsOpen

            if (carLayoutIsOpen) {
                binding.openCarIcon.setImageResource(R.drawable.ic_close_circle)
                binding.carLayout.setBackgroundColor(resources.getColor(R.color.alternative_background, resources.newTheme()))
            } else {
                binding.openCarIcon.setImageResource(R.drawable.ic_open_circle)
                binding.carLayout.background = ContextCompat.getDrawable(requireContext(), R.drawable.item_background_selector)
            }
        }
        binding.busLayout.setOnClickListener {
            busLayoutIsOpen = !busLayoutIsOpen

            binding.busDescription.isVisible = busLayoutIsOpen

            if (busLayoutIsOpen) {
                binding.openBusIcon.setImageResource(R.drawable.ic_close_circle)
                binding.busLayout.setBackgroundColor(resources.getColor(R.color.alternative_background, resources.newTheme()))
            } else {
                binding.openBusIcon.setImageResource(R.drawable.ic_open_circle)
                binding.busLayout.background = ContextCompat.getDrawable(requireContext(), R.drawable.item_background_selector)
            }
        }
        binding.trainLayout.setOnClickListener {
            trainLayoutIsOpen = !trainLayoutIsOpen

            binding.trainDescription.isVisible = trainLayoutIsOpen
            binding.trainDescription2.isVisible = trainLayoutIsOpen
            binding.trainDescription3.isVisible = trainLayoutIsOpen
            binding.trainDescription4.isVisible = trainLayoutIsOpen
            binding.trainDescription5.isVisible = trainLayoutIsOpen

            if (trainLayoutIsOpen) {
                binding.openTrainIcon.setImageResource(R.drawable.ic_close_circle)
                binding.trainLayout.setBackgroundColor(resources.getColor(R.color.alternative_background, resources.newTheme()))
            } else {
                binding.openTrainIcon.setImageResource(R.drawable.ic_open_circle)
                binding.trainLayout.background = ContextCompat.getDrawable(requireContext(), R.drawable.item_background_selector)
            }
        }
        binding.planeLayout.setOnClickListener {
            planeLayoutIsOpen = !planeLayoutIsOpen

            binding.planeDescription.isVisible = planeLayoutIsOpen
            binding.planeDescription2.isVisible = planeLayoutIsOpen
            binding.planeDescription3.isVisible = planeLayoutIsOpen

            if (planeLayoutIsOpen) {
                binding.openPlaneIcon.setImageResource(R.drawable.ic_close_circle)
                binding.planeLayout.setBackgroundColor(resources.getColor(R.color.alternative_background, resources.newTheme()))
            } else {
                binding.openPlaneIcon.setImageResource(R.drawable.ic_open_circle)
                binding.planeLayout.background = ContextCompat.getDrawable(requireContext(), R.drawable.item_background_selector)
            }
        }
        binding.boatLayout.setOnClickListener {
            boatLayoutIsOpen = !boatLayoutIsOpen

            binding.boatDescription.isVisible = boatLayoutIsOpen
            binding.boatDescription2.isVisible = boatLayoutIsOpen
            binding.boatDescription3.isVisible = boatLayoutIsOpen

            if (boatLayoutIsOpen) {
                binding.openBoatIcon.setImageResource(R.drawable.ic_close_circle)
                binding.boatLayout.setBackgroundColor(resources.getColor(R.color.alternative_background, resources.newTheme()))
            } else {
                binding.openBoatIcon.setImageResource(R.drawable.ic_open_circle)
                binding.boatLayout.background = ContextCompat.getDrawable(requireContext(), R.drawable.item_background_selector)
            }
        }
    }
}