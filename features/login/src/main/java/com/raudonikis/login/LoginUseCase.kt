package com.raudonikis.login

import com.haroldadmin.cnradapter.NetworkResponse
import com.raudonikis.common.Result
import com.raudonikis.common.coroutines.CoroutineDispatcherProvider
import com.raudonikis.network.AuthenticationApi
import com.raudonikis.network.login.LoginRequestBody
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authenticationApi: AuthenticationApi,
    private val dispatcherProvider: CoroutineDispatcherProvider,
) {

    suspend fun login(username: String, password: String): Result {
        return withContext(dispatcherProvider.ioDispatcher) {
            val loginRequestBody = LoginRequestBody(
                username = username,
                password = password
            )
            when (authenticationApi.login(loginRequestBody)) {
                is NetworkResponse.Success -> {
                    return@withContext Result.Success
                }
                else -> {
                    return@withContext Result.Failure
                }
            }
        }
    }
}