package com.raudonikis.profile.user

import com.haroldadmin.cnradapter.NetworkResponse
import com.raudonikis.common.Result
import com.raudonikis.common.coroutines.CoroutineDispatcherProvider
import com.raudonikis.network.AuthenticationApi
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val authenticationApi: AuthenticationApi,
    private val dispatcherProvider: CoroutineDispatcherProvider,
) {

    suspend fun getUser(): Result<User> {
        return withContext(dispatcherProvider.ioDispatcher) {
            when(val result = authenticationApi.getUser()) {
                is NetworkResponse.Success -> {
                    val user = UserMapper.fromUserResponse(result.body)
                    return@withContext Result.Success(user)
                }
                else -> {
                    return@withContext Result.Failure()
                }
            }
        }
    }
}