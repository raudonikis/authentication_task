package com.raudonikis.profile.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.raudonikis.common.Outcome
import com.raudonikis.common_ui.showIf
import com.raudonikis.common_ui.showLongSnackbar
import com.raudonikis.profile.R
import com.raudonikis.profile.user.User
import com.raudonikis.profile.databinding.FragmentProfileBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private val viewModel: ProfileViewModel by viewModels()
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    /**
     * Lifecycle hooks
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
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

    /**
     * Set up
     */
    private fun setUpListeners() {
        binding.buttonLogout.setOnClickListener {
            viewModel.onLogoutClicked()
        }
    }

    private fun setUpObservers() {
        lifecycleScope.launchWhenCreated {
            viewModel.user
                .onEach { onUserUpdate(it) }
                .collect()
        }
    }

    /**
     * Events
     */
    private fun onUserUpdate(userUpdate: Outcome<User>) {
        binding.bindUser(userUpdate)
        userUpdate.onFailure {
            showLongSnackbar(R.string.error_get_user_generic)
        }
    }
}