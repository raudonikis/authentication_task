package com.raudonikis.network.login

import com.squareup.moshi.Json

/**
 * Defines the model for a login response
 */
data class LoginResponse(
    @Json(name = "token")
    val accessToken: String,
    @Json(name = "refreshToken")
    val refreshToken: String,
)