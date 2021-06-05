package com.raudonikis.network

import com.haroldadmin.cnradapter.NetworkResponse
import com.raudonikis.network.login.LoginRequestBody
import com.raudonikis.network.login.LoginResponse
import com.raudonikis.network.user.UserResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthenticationApi {

    @POST("credentials")
    suspend fun login(@Body loginRequest: LoginRequestBody): NetworkResponse<LoginResponse, Unit>

    @GET("user")
    suspend fun getUser(): NetworkResponse<UserResponse, Unit>

    companion object {
        const val baseUrl = "https://vidqjclbhmef.herokuapp.com/"
    }
}