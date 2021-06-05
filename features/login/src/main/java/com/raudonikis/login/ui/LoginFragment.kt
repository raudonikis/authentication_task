package com.raudonikis.login.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.raudonikis.common_ui.enableIf
import com.raudonikis.common_ui.showIf
import com.raudonikis.common_ui.showLongSnackbar
import com.raudonikis.login.R
import com.raudonikis.login.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.fragment_login) {

    private val viewModel: LoginViewModel by viewModels()
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObservers()
        setUpListeners()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setUpListeners() {
        binding.apply {
            buttonSubmit.setOnClickListener {
                val username = textUsername.editText?.text.toString()
                val password = textPassword.editText?.text.toString()
                viewModel.onSubmitClicked(username, password)
            }
        }
    }

    private fun setUpObservers() {
        lifecycleScope.launchWhenCreated {
            viewModel.loginEvent
                .onEach { onLoginEvent(it) }
                .collect()
        }
    }

    private fun onLoginEvent(event: LoginEvent) {
        binding.apply {
            progressLogin.showIf { event is LoginEvent.Loading }
            buttonSubmit.enableIf { event !is LoginEvent.Loading }
            if (event is LoginEvent.Failure) {
                showLongSnackbar("Failed to login")
            }
        }
    }
}