package com.raudonikis.network.user

import com.squareup.moshi.Json

/**
 * Defines the model for a user response
 */
data class UserResponse(
    @Json(name = "uuid")
    val uuid: String,
    @Json(name = "image")
    val image: String,
    @Json(name = "firstName")
    val firstName: String,
    @Json(name = "lastName")
    val lastName: String,
    @Json(name = "address")
    val address: String,
    @Json(name = "phone")
    val phone: String,
)