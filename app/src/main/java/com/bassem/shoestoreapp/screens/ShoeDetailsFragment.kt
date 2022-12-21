package com.bassem.shoestoreapp.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.bassem.shoestoreapp.R
import com.bassem.shoestoreapp.databinding.FragmentShoeDetailsBinding
import com.bassem.shoestoreapp.databinding.FragmentWelcomeBinding
import com.bassem.shoestoreapp.viewmodels.LoginViewModel
import com.bassem.shoestoreapp.viewmodels.ShoeViewModel


class ShoeDetailsFragment : Fragment() {
    private lateinit var shoeDetailsBinding: FragmentShoeDetailsBinding
    private lateinit var shoeViewModel: ShoeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        shoeDetailsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_details, container, false
        )

        shoeViewModel = ViewModelProvider(requireActivity())[ShoeViewModel::class.java]

        shoeDetailsBinding.shoeDetailsViewModel = shoeViewModel



        shoeDetailsBinding.cancelButton.setOnClickListener { v: View ->
            v.findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoesListFragment())
        }

        shoeViewModel.getIsLoginSuccess().observe(viewLifecycleOwner) {
            if (it) {
                findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoesListFragment())
            } else {
                Toast.makeText(this.context, "Please,Fill Missing Data", Toast.LENGTH_LONG).show()
            }
        }
        return shoeDetailsBinding.root
    }
}