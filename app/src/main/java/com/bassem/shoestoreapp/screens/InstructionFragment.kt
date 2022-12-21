package com.bassem.shoestoreapp.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.bassem.shoestoreapp.R
import com.bassem.shoestoreapp.databinding.FragmentInstructionBinding
import com.bassem.shoestoreapp.databinding.FragmentWelcomeBinding

class InstructionFragment : Fragment() {
    private lateinit var instructionsBinding: FragmentInstructionBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        instructionsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_instruction, container, false
        )

        instructionsBinding.letsStartButton.setOnClickListener { v: View ->
            v.findNavController().navigate(InstructionFragmentDirections.actionInstructionFragmentToShoesListFragment())

        }


        return instructionsBinding.root
    }

}