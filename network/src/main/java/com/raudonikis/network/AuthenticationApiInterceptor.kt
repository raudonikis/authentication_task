package com.raudonikis.network

import com.raudonikis.auth.AuthenticationPreferences
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

/**
 * Interceptor for [AuthenticationApi]
 * Adds authorization header to every request
 */
internal class AuthenticationApiInterceptor @Inject constructor(
    private val authenticationPreferences: AuthenticationPreferences,
) : Interceptor {

    private val headers: Map<String, String>
        get() = mapOf("Authorization" to "Bearer ${authenticationPreferences.accessToken}")

    override fun intercept(chain: Interceptor.Chain): Response {
        with(addHeaders(chain.request())) {
            return chain.proceed(
                newBuilder()
                    .url(url)
                    .build()
            )
        }
    }

    private fun addHeaders(request: Request): Request {
        return request
            .newBuilder()
            .apply {
                headers.map { header ->
                    addHeader(header.key, header.value)
                }
            }
            .build()
    }
}