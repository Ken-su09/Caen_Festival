package com.suonk.caen_festival.ui.places

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.suonk.caen_festival.R
import com.suonk.caen_festival.databinding.FragmentPlacesListBinding
import com.suonk.caen_festival.ui.home.HomeFragment
import com.suonk.caen_festival.ui.main.MainActivity
import com.suonk.caen_festival.utils.viewBinding

class PlacesListFragment : Fragment(R.layout.fragment_places_list) {

    private val binding by viewBinding(FragmentPlacesListBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listAdapter = PlacesListAdapter()
        listAdapter.submitList(placesList())
        binding.placesList.adapter = listAdapter
    }

    private fun placesList(): List<PlaceItemViewState> {
        return arrayListOf(
            PlaceItemViewState(
                1,
                "Le Zénith de Caen",
                "https://media.discordapp.net/attachments/686979487258378281/1128070470516887744/image.png?width=905&height=571"
            ),
            PlaceItemViewState(
                2,
                "Parc des expositions de Caen",
                "https://media.discordapp.net/attachments/686979487258378281/1128070582534156381/image.png?width=905&height=571"
            ),
            PlaceItemViewState(
                3,
                "Centre de congré de Caen",
                "https://media.discordapp.net/attachments/686979487258378281/1128070834003648572/image.png?width=905&height=571"
            ),
            PlaceItemViewState(
                4,
                "Le Wip",
                "https://media.discordapp.net/attachments/686979487258378281/1128070904795115550/image.png?width=905&height=571"
            ),
            PlaceItemViewState(
                5,
                "Centre de conférence du crédit agricole normandie",
                "https://media.discordapp.net/attachments/686979487258378281/1128071028992659477/image.png?width=905&height=571"
            ),
        )
    }
}