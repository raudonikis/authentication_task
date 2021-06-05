package com.raudonikis.login

import com.haroldadmin.cnradapter.NetworkResponse
import com.raudonikis.common.Result
import com.raudonikis.common.coroutines.CoroutineDispatcherProvider
import com.raudonikis.data_domain.AuthenticationPreferences
import com.raudonikis.network.AuthenticationApi
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authenticationApi: AuthenticationApi,
    private val dispatcherProvider: CoroutineDispatcherProvider,
    private val authenticationPreferences: AuthenticationPreferences,
) {

    suspend fun login(username: String, password: String): Result {
        return withContext(dispatcherProvider.ioDispatcher) {
            when (val result = authenticationApi.login(username, password)) {
                is NetworkResponse.Success -> {
                    authenticationPreferences.accessToken = result.body.accessToken
                    authenticationPreferences.refreshToken = result.body.refreshToken
                    return@withContext Result.Success
                }
                else -> {
                    return@withContext Result.Failure
                }
            }
        }
    }
}