package com.raudonikis.login

import com.haroldadmin.cnradapter.NetworkResponse
import com.raudonikis.auth.AuthenticationPreferences
import com.raudonikis.common.Outcome
import com.raudonikis.common.coroutines.CoroutineDispatcherProvider
import com.raudonikis.network.AuthenticationApi
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authenticationApi: AuthenticationApi,
    private val dispatcherProvider: CoroutineDispatcherProvider,
    private val authenticationPreferences: AuthenticationPreferences,
) {

    suspend fun login(username: String, password: String): Outcome<Unit> {
        return withContext(dispatcherProvider.ioDispatcher) {
            when (val result = authenticationApi.login(username, password)) {
                is NetworkResponse.Success -> {
                    authenticationPreferences.accessToken = result.body.accessToken
                    authenticationPreferences.refreshToken = result.body.refreshToken
                    return@withContext Outcome.Success(Unit)
                }
                else -> {
                    return@withContext Outcome.Failure()
                }
            }
        }
    }
}