package com.raudonikis.profile.user

import com.haroldadmin.cnradapter.NetworkResponse
import com.raudonikis.common.Outcome
import com.raudonikis.common.coroutines.CoroutineDispatcherProvider
import com.raudonikis.network.AuthenticationApi
import com.raudonikis.network.user.UserResponse
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.io.IOException

@ExperimentalCoroutinesApi
internal class GetUserUseCaseTest {

    private lateinit var sut: GetUserUseCase

    @RelaxedMockK
    private lateinit var authenticationApi: AuthenticationApi

    private val testDispatcher = TestCoroutineDispatcher()
    private val coroutineDispatcherProvider = CoroutineDispatcherProvider(
        ioDispatcher = testDispatcher,
        mainDispatcher = testDispatcher,
        defaultDispatcher = testDispatcher,
    )

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        sut = GetUserUseCase(
            authenticationApi,
            coroutineDispatcherProvider,
        )
    }

    @Test
    fun `getUser, calls API getUser method`() = runBlockingTest {
        //Assemble
        coEvery { authenticationApi.getUser() } returns NetworkResponse.UnknownError(Throwable())
        //Act
        sut.getUser()
        //Assert
        coVerify { authenticationApi.getUser() }
    }

    @Test
    fun `getUser, when API Unknown error, returns Failure`() = runBlockingTest {
        //Assemble
        coEvery { authenticationApi.getUser() } returns NetworkResponse.UnknownError(Throwable())
        val expectedResult = Outcome.Failure()
        //Act
        val result = sut.getUser()
        //Assert
        assertEquals(expectedResult, result)
    }

    @Test
    fun `getUser, when API Network error, returns Failure`() = runBlockingTest {
        //Assemble
        coEvery { authenticationApi.getUser() } returns NetworkResponse.NetworkError(IOException())
        val expectedResult = Outcome.Failure()
        //Act
        val result = sut.getUser()
        //Assert
        assertEquals(expectedResult, result)
    }

    @Test
    fun `getUser, when API Server error, returns Failure`() = runBlockingTest {
        //Assemble
        coEvery { authenticationApi.getUser() } returns NetworkResponse.ServerError(
            code = 500,
            body = null
        )
        val expectedResult = Outcome.Failure()
        //Act
        val result = sut.getUser()
        //Assert
        assertEquals(expectedResult, result)
    }

    @Test
    fun `getUser, when API Success, returns Success`() = runBlockingTest {
        //Assemble
        val response = UserResponse("", "", "", "", "", "")
        coEvery { authenticationApi.getUser() } returns NetworkResponse.Success(
            body = response,
            code = 200,
        )
        val expectedResult = Outcome.Success(UserMapper.fromUserResponse(response))
        //Act
        val result = sut.getUser()
        //Assert
        assertEquals(expectedResult, result)
    }
}