package com.vukdev.triviaapp_navbarsidedropmenu

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.vukdev.triviaapp_navbarsidedropmenu.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding: FragmentTitleBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_title, container, false)

        binding.playButton.setOnClickListener {view: View ->
        // Ovaj se isto menja sa safe args
        // Navigation.createNavigateOnClickListener(R.id.action_titleFragment_to_gameFragment)
        view.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToGameFragment())
        }

        // dodajem drop down menu, tj menu sa tri tacke
        // ukoliko bih ga dodao MainActivity-ju umesto ovde onda bi sbvaki fragment imao ovaj menu
        setHasOptionsMenu(true)

        return  binding.root

    }

    // drop down menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!, view!!.findNavController()) || super.onOptionsItemSelected(item)
    }
}
