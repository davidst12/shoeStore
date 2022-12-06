package com.udacity.shoestore.screens.shoedetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeListViewModel

class ShoeDetailFragment : Fragment() {

    //View model for the activity
    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding: FragmentShoeDetailBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_detail, container, false)

        //Binding variables from the layout
        binding.shoeViewModel = viewModel
        binding.shoeItem = Shoe("",0.0, "", "")

        binding.lifecycleOwner = this

        //Navigate to shoeListFragment when shoeDetailCancelButton is pressed doing nothing
        binding.shoeDetailCancelButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_shoeDetailFragment_to_shoeListFragment))

        //Observe event for button pressed
        viewModel.eventInsertNewShoe.observe(viewLifecycleOwner, Observer { buttonPressed ->
            if (buttonPressed){
                //Send the new shoe to the viewModel
                viewModel.addShoe(binding.shoeItem!!)
                //Navigate to shoeListFragment
                findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
                //Logic when addNewShoeButton is pressed complete
                viewModel.onButtonPressedComplete()
            }
        })
        return binding.root
    }

}