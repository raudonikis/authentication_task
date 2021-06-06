package com.raudonikis.auth

import android.content.SharedPreferences
import com.auth0.android.jwt.JWT
import com.raudonikis.common.get
import com.raudonikis.common.put
import timber.log.Timber
import javax.inject.Inject

/**
 * SharedPreferences utility class for authentication data
 */
class AuthenticationPreferences @Inject constructor(
    private val sharedPreferences: SharedPreferences,
) {
    var accessToken: String
        get() = sharedPreferences.get(KEY_ACCESS_TOKEN, "")
        set(value) {
            sharedPreferences.put(KEY_ACCESS_TOKEN, value)
        }

    var refreshToken: String
        get() = sharedPreferences.get(KEY_REFRESH_TOKEN, "")
        set(value) {
            sharedPreferences.put(KEY_REFRESH_TOKEN, value)
        }

    fun isUserAuthenticated(): Boolean {
        return try {
            val jwt = JWT(accessToken)
            !jwt.isExpired(10)
        } catch (e: Exception) {
            Timber.w("Could not decode the JWT token -> ${e.message}")
            false
        }
    }

    fun clearUserData() {
        accessToken = ""
        refreshToken = ""
    }

    companion object {
        private const val KEY_ACCESS_TOKEN = "access_token"
        private const val KEY_REFRESH_TOKEN = "refresh_token"
    }
}