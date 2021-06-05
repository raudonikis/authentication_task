package com.raudonikis.network.login

import com.squareup.moshi.Json

data class LoginResponse(
    @Json(name = "token")
    val accessToken: String,
    @Json(name = "refreshToken")
    val refreshToken: String,
)