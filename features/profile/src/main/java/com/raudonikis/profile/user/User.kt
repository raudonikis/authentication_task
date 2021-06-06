package com.raudonikis.profile.user

data class User(
    val uuid: String,
    val image: String,
    val firstName: String,
    val lastName: String,
    val address: String,
    val phone: String,
) {
    val fullName: String
        get() = "$firstName $lastName"
}