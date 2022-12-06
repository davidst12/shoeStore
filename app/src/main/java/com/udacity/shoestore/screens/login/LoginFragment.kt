package com.udacity.shoestore.screens.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding: FragmentLoginBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false
        )

        //Navigate to welcomeFragment when signButton is pressed
        binding.signupButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_welcomeFragment))

        binding.loginButton.setOnClickListener { v: View ->
            //Navigate to welcomeFragment when loginButton is pressed and mail and password are filled
            if((binding.editTextTextEmailAddress.text.toString() != "")&&(binding.editTextTextPassword.text.toString() != "")){
                v.findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
            // If mail and password are not filled, we show a toast and we don't navigate
            }else{
                Toast.makeText(context, "Insert email and password", Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }
}