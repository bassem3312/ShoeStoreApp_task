package com.bassem.shoestoreapp.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bassem.shoestoreapp.R
import com.bassem.shoestoreapp.databinding.FragmentLoginBinding
import com.bassem.shoestoreapp.viewmodels.LoginViewModel

class LoginFragment : Fragment() {
    private lateinit var loginViewModel: LoginViewModel
    private lateinit var loginBinding: FragmentLoginBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        loginBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false
        )


        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        loginBinding.loginViewModel = loginViewModel

        initObservers()
        return loginBinding.root
    }

    private fun initObservers() {
        loginViewModel.getIsLoginSuccess().observe(viewLifecycleOwner, Observer {
            if (it) {
                navigateToNextActivity()
            } else {
                Toast.makeText(this.context, "Enter valid email and password", Toast.LENGTH_LONG).show()

            }
        })
    }

    private fun navigateToNextActivity() {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
    }
}


