package com.raudonikis.network

import com.haroldadmin.cnradapter.NetworkResponse
import com.raudonikis.network.login.LoginResponse
import com.raudonikis.network.user.UserResponse
import retrofit2.http.*

/**
 * Api for authentication and user endpoints
 */
interface AuthenticationApi {

    @FormUrlEncoded
    @POST("credentials")
    suspend fun login(
        @Field("username") username: String,
        @Field("password") password: String,
    ): NetworkResponse<LoginResponse, Unit>

    @GET("user")
    suspend fun getUser(): NetworkResponse<UserResponse, Unit>

    companion object {
        const val baseUrl = "https://vidqjclbhmef.herokuapp.com/"
    }
}