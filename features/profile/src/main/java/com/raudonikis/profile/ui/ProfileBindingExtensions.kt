package com.raudonikis.profile.ui

import com.bumptech.glide.Glide
import com.raudonikis.common.Outcome
import com.raudonikis.common_ui.showIf
import com.raudonikis.profile.databinding.FragmentProfileBinding
import com.raudonikis.profile.user.User

fun FragmentProfileBinding.bindUser(userUpdate: Outcome<User>) {
    progressUser.showIf { userUpdate is Outcome.Loading }
    userUpdate.onSuccess { user ->
        textAddress.text = user.address
        textPhone.text = user.phone
        textUserName.text = user.fullName
        Glide
            .with(root)
            .load(user.image)
            .centerCrop()
            .into(imageUserPhoto)
    }
}