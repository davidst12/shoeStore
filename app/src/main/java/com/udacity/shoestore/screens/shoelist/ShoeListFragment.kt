package com.udacity.shoestore.screens.shoelist

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.ShoeListViewModel
import kotlinx.android.synthetic.main.shoe.view.*

class ShoeListFragment : Fragment() {

    //View model for the activity
    private val viewModel: ShoeListViewModel by activityViewModels()

    private lateinit var shoeView: View

    @SuppressLint("InflateParams")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding: FragmentShoeListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_list, container, false)

        // Enable menu in the view
        setHasOptionsMenu(true)

        binding.lifecycleOwner = this

        //Inflate shoeView for each shoe in the shoeList of the ViewModel
        viewModel.shoeList.forEach { shoe ->
            shoeView = inflater.inflate(R.layout.shoe, null, false)
            shoeView.shoeNameItem.text = shoe.name
            shoeView.shoeCompanyItem.text = shoe.company
            shoeView.shoeSizeItem.text = shoe.size.toString()
            shoeView.shoeDescriptionItem.text = shoe.description

            //Add view in the layout of the scrollView (id=list)
            binding.list.addView(shoeView)
        }

        //Navigate to shoeDetailFragment when addNewShoeButton is pressed (with any logic)
        binding.addNewShoeButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_shoeListFragment_to_shoeDetailFragment))

        return binding.root
    }

    //Inflate menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    //Navigate when the item in the menu is pressed
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController()) || super.onOptionsItemSelected(item)
    }
}