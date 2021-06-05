package com.raudonikis.login

import com.haroldadmin.cnradapter.NetworkResponse
import com.raudonikis.auth.AuthenticationPreferences
import com.raudonikis.common.Result
import com.raudonikis.common.coroutines.CoroutineDispatcherProvider
import com.raudonikis.network.AuthenticationApi
import com.raudonikis.network.login.LoginResponse
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.io.IOException

@ExperimentalCoroutinesApi
internal class LoginUseCaseTest {
    private lateinit var sut: LoginUseCase

    @RelaxedMockK
    private lateinit var authenticationApi: AuthenticationApi

    @RelaxedMockK
    private lateinit var authenticationPreferences: AuthenticationPreferences

    private val testDispatcher = TestCoroutineDispatcher()
    private val coroutineDispatcherProvider = CoroutineDispatcherProvider(
        ioDispatcher = testDispatcher,
        mainDispatcher = testDispatcher,
        defaultDispatcher = testDispatcher,
    )

    private val username = "username"
    private val password = "password"

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        sut = LoginUseCase(
            authenticationApi,
            coroutineDispatcherProvider,
            authenticationPreferences,
        )
    }

    @Test
    fun `login, calls API login method`() = runBlockingTest {
        //Assemble
        coEvery { authenticationApi.login(any(), any()) } returns NetworkResponse.UnknownError(Throwable())
        //Act
        sut.login(username, password)
        //Assert
        coVerify { authenticationApi.login(username, password) }
    }

    @Test
    fun `login, when API Unknown error, returns Failure`() = runBlockingTest {
        //Assemble
        coEvery { authenticationApi.login(any(), any()) } returns NetworkResponse.UnknownError(Throwable())
        val expectedResult = Result.Failure()
        //Act
        val result = sut.login(username, password)
        //Assert
        Assert.assertEquals(expectedResult, result)
    }

    @Test
    fun `login, when API Network error, returns Failure`() = runBlockingTest {
        //Assemble
        coEvery { authenticationApi.login(any(), any()) } returns NetworkResponse.NetworkError(IOException())
        val expectedResult = Result.Failure()
        //Act
        val result = sut.login(username, password)
        //Assert
        Assert.assertEquals(expectedResult, result)
    }

    @Test
    fun `login, when API Server error, returns Failure`() = runBlockingTest {
        //Assemble
        coEvery { authenticationApi.login(any(), any()) } returns NetworkResponse.ServerError(
            code = 500,
            body = null
        )
        val expectedResult = Result.Failure()
        //Act
        val result = sut.login(username, password)
        //Assert
        Assert.assertEquals(expectedResult, result)
    }

    @Test
    fun `login, when API Success, returns Success`() = runBlockingTest {
        //Assemble
        val accessToken = "access-token"
        val refreshToken = "refresh-token"
        val response = LoginResponse(accessToken, refreshToken)
        coEvery { authenticationApi.login(any(), any()) } returns NetworkResponse.Success(
            body = response,
            code = 200,
        )
        val expectedResult = Result.Success(Unit)
        //Act
        val result = sut.login(username, password)
        //Assert
        Assert.assertEquals(expectedResult, result)
    }

    @Test
    fun `login, when API Success, updates tokens`() = runBlockingTest {
        //Assemble
        val accessToken = "access-token"
        val refreshToken = "refresh-token"
        val response = LoginResponse(accessToken, refreshToken)
        coEvery { authenticationApi.login(any(), any()) } returns NetworkResponse.Success(
            body = response,
            code = 200,
        )
        //Act
        sut.login(username, password)
        //Assert
        verify { authenticationPreferences.accessToken = accessToken }
        verify { authenticationPreferences.refreshToken = refreshToken }
    }
}